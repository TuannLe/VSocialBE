package org.tuanle.vsocialbe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.tuanle.vsocialbe.dto.request.AccountUpdateRequest;
import org.tuanle.vsocialbe.dto.request.RegisterRequest;
import org.tuanle.vsocialbe.dto.response.AccountResponse;
import org.tuanle.vsocialbe.entity.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toAccount(RegisterRequest request);

    @Mapping(target = "roles", ignore = true)
    void updateAccount(@MappingTarget Account account, AccountUpdateRequest request);

    AccountResponse toAccountResponse(Account account);
}
