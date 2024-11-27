package org.tuanle.vsocialbe.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.tuanle.vsocialbe.dto.request.RegisterRequest;
import org.tuanle.vsocialbe.dto.request.AccountUpdateRequest;
import org.tuanle.vsocialbe.dto.response.APIResponse;
import org.tuanle.vsocialbe.dto.response.AccountResponse;
import org.tuanle.vsocialbe.entity.Account;
import org.tuanle.vsocialbe.service.interfaces.IAccountService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {
    IAccountService accountService;

    @PostMapping("/register")
    public APIResponse<Account> register(@RequestBody @Valid RegisterRequest request) {
        APIResponse<Account> response = new APIResponse<>();
        response.setResult(accountService.register(request));
        return response;
    }

    @GetMapping("/all")
    public APIResponse<List<AccountResponse>> getAllUser(){
        return APIResponse.<List<AccountResponse>>builder()
                .result(accountService.getAll())
                .build();
    }

    @GetMapping("/my-info")
    public APIResponse<AccountResponse> getMyInfo(){
        return APIResponse.<AccountResponse>builder()
                .result(accountService.getMyInfo())
                .build();
    }

    @GetMapping("/{accountId}")
    public AccountResponse getById(@PathVariable String accountId) {
        return accountService.getById(accountId);
    }

    @PutMapping("/{accountId}")
    public AccountResponse update(@PathVariable String accountId, @RequestBody AccountUpdateRequest request) {
        return accountService.update(accountId, request);
    }
}
