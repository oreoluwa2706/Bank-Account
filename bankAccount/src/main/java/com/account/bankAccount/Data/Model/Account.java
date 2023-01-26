package com.account.bankAccount.Data.Model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Account {
    private String accountNumber;
    private String accountPin;
    private BigDecimal balance;

}
