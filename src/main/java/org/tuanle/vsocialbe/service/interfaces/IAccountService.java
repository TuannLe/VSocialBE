package org.tuanle.vsocialbe.service.interfaces;

import org.tuanle.vsocialbe.dto.request.AccountUpdateRequest;
import org.tuanle.vsocialbe.dto.request.RegisterRequest;
import org.tuanle.vsocialbe.dto.response.AccountFriendResponse;
import org.tuanle.vsocialbe.dto.response.AccountResponse;
import org.tuanle.vsocialbe.entity.Account;

import java.util.List;

public interface IAccountService {
    Account register(RegisterRequest request);

    List<AccountResponse> getAll();

    List<AccountFriendResponse> findAccountByKeyword(String accountId, String keyword);

    AccountResponse getById(String accountId);

    AccountResponse getMyInfo();

    AccountResponse update(String accountId, AccountUpdateRequest request);
}
