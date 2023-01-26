package com.account.bankAccount.Services;

import com.account.bankAccount.DTOs.AccountRequest;
import com.account.bankAccount.Data.Model.User;
import com.account.bankAccount.Data.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    AccountRepository accountRepository;
    public void createUser(AccountRequest accountRequest) {
        User user = new User();
        user.setFirstName(accountRequest.getFirstName());
        user.setLastName(accountRequest.getLastName());
        user.setPhoneNumber(accountRequest.getPhoneNumber());
        user.setAccount(accountRequest.getAccount());
        accountRepository.save(user);
    }

    public List<User> getAllUser() {
        return accountRepository.findAll();
    }

    public User getUserByUserId(String userId) {
        Optional<User> user = accountRepository.findById(userId);
        if(user.isPresent()){
            return accountRepository.findById(userId).get();
        }
        else {
            throw new IllegalArgumentException("user with userId " + userId + " is not found");
        }
    }

    public void deleteUserById(String userId) {
        accountRepository.deleteById(userId);
    }

    public void deleteAllUser() {
        accountRepository.deleteAll();
    }

    public void deposit(String userId, BigDecimal depositAmount) {
        Optional<User> user = accountRepository.findById(userId);
        boolean exist = user.isPresent();
        if (!exist){
            throw new IllegalArgumentException("User with userId "+ userId +" not found");
        }
        BigDecimal currentBalance = user.get().getAccount().getBalance();
        BigDecimal newBalance = currentBalance.add(depositAmount);
        user.get().getAccount().setBalance(newBalance);
        accountRepository.save(user.get());
    }

    public void withdraw(String userId, BigDecimal withdrawAmount) {
        Optional<User> user = accountRepository.findById(userId);
        boolean exist = user.isPresent();
        if (!exist){
            throw new IllegalArgumentException("user with userId " + userId +" not found");
        }
        BigDecimal currentBalance = user.get().getAccount().getBalance();
        if(withdrawAmount.compareTo(currentBalance) > 0){
            throw new IllegalArgumentException("insufficient balance");
        }
        BigDecimal newBalance = currentBalance.subtract(withdrawAmount);
        user.get().getAccount().setBalance(newBalance);
        accountRepository.save(user.get());
    }

    public void transfer(String senderId, String receiverId, BigDecimal transferAmount) {
        if(senderId.equals(receiverId)){
            throw new IllegalArgumentException("sender account must be different from receiver account");
        }
        withdraw(senderId, transferAmount);
        deposit(receiverId, transferAmount);
    }

    public void changePin(String userId, String newPin) {
        Optional<User> user = accountRepository.findById(userId);
        boolean exist = user.isPresent();
        if (!exist){
            throw new IllegalArgumentException("user with userId "+ userId +" not found");
        }
        user.get().getAccount().setAccountPin(newPin);
        accountRepository.save(user.get());
    }
}
