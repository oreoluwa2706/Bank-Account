package com.account.bankAccount.DTOs;

import com.account.bankAccount.Data.Model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Account account;

}
