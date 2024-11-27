package org.tuanle.vsocialbe.service.implementations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.tuanle.vsocialbe.dto.request.AccountUpdateRequest;
import org.tuanle.vsocialbe.dto.request.RegisterRequest;
import org.tuanle.vsocialbe.dto.response.AccountResponse;
import org.tuanle.vsocialbe.entity.Account;
import org.tuanle.vsocialbe.enums.Role;
import org.tuanle.vsocialbe.exception.AppException;
import org.tuanle.vsocialbe.exception.ErrorCode;
import org.tuanle.vsocialbe.mapper.AccountMapper;
import org.tuanle.vsocialbe.repositoty.AccountRepo;
import org.tuanle.vsocialbe.repositoty.RoleRepo;
import org.tuanle.vsocialbe.service.interfaces.IAccountService;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountService implements IAccountService {
    AccountRepo accountRepo;
    AccountMapper accountMapper;
    PasswordEncoder passwordEncoder;
    RoleRepo roleRepo;

    @Override
    public RegisterRequest login(RegisterRequest account) {
        return null;
    }

    @Override
    public Account register(RegisterRequest request) {
        if(accountRepo.existsByEmail(request.getEmail())){
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }
        Account account = accountMapper.toAccount(request);
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        HashSet<Role> roles = new HashSet<>();
        roles.add(Role.USER);
//        account.setRoles(roles);
        return accountRepo.save(account);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public List<AccountResponse> getAll() {
        return accountRepo.findAll().stream().map(accountMapper::toAccountResponse).toList();
    }

    @PostAuthorize("returnObject.email == authentication.name")
    @Override
    public AccountResponse getById(String accountId) {
        return accountMapper.toAccountResponse(accountRepo.findById(accountId).orElseThrow(() -> new AppException(ErrorCode.EMAIL_NOT_EXISTED)));
    }

    @PreAuthorize("hasAuthority('GET_MY_INFO')")
    @Override
    public AccountResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String email = context.getAuthentication().getName();
        Account account = accountRepo.findByEmail(email).orElseThrow(() -> new AppException(ErrorCode.EMAIL_NOT_EXISTED));
        return accountMapper.toAccountResponse(account);
    }

    @Override
    public AccountResponse update(String accountId, AccountUpdateRequest request) {
        Account existingAccount = accountRepo.findById(accountId).orElseThrow(() -> new AppException(ErrorCode.EMAIL_NOT_EXISTED));
        accountMapper.updateAccount(existingAccount, request);
        var roles = roleRepo.findAllById(request.getRoles());
        existingAccount.setRoles(new HashSet<>(roles));
        return accountMapper.toAccountResponse(accountRepo.save(existingAccount));
    }

    @Override
    public List<Account> findAccountByUsername(String username) {
        return List.of();
    }
}

