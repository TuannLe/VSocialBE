package org.tuanle.vsocialbe.service.interfaces;

import org.tuanle.vsocialbe.dto.request.AccountUpdateRequest;
import org.tuanle.vsocialbe.dto.request.RegisterRequest;
import org.tuanle.vsocialbe.dto.response.AccountResponse;
import org.tuanle.vsocialbe.entity.Account;

import java.util.List;

public interface IAccountService {
    RegisterRequest login(RegisterRequest account);

    Account register(RegisterRequest request);

    List<AccountResponse> getAll();

    List<Account> findAccountByUsername(String username);

    AccountResponse getById(String accountId);

    AccountResponse getMyInfo();

    AccountResponse update(String accountId, AccountUpdateRequest request);
}
