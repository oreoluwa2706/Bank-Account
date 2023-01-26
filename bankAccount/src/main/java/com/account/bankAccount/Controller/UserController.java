package com.account.bankAccount.Controller;

import com.account.bankAccount.DTOs.AccountRequest;
import com.account.bankAccount.Data.Model.User;
import com.account.bankAccount.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/create")
    public String createNewUser(@RequestBody AccountRequest accountRequest){
        userService.createUser(accountRequest);
        return "Successful";
    }
    @GetMapping("/all")
    public List<User> viewAll(){
        return userService.getAllUser();
    }
    @GetMapping("{userId}")
    public User getUser(@PathVariable String userId){

        return userService.getUserByUserId(userId);
    }
    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable String userId){
    userService.deleteUserById(userId);
        return "deleted successfully";
    }
    @DeleteMapping("/delete")
    public String deleteAllUser(){
        userService.deleteAllUser();
        return "All User successfully deleted";
    }
    @PostMapping("/deposit/{userId}/{depositAmount}")
    public String makeDeposit(@PathVariable("userId") String userId,
                              @PathVariable("depositAmount") BigDecimal depositAmount){
        userService.deposit(userId, depositAmount);
        return "successful";
    }

    @PostMapping("/withdraw/{userId}/{withdrawAmount}")
    public String makeWithdraw(@PathVariable("userId") String userId,
                               @PathVariable("withdrawAmount") BigDecimal withdrawAmount){
        userService.withdraw(userId, withdrawAmount);
        return "successful withdrawal...thank you for banking with us";
    }
    @PostMapping("/transfer/{userId}/{receiverId}/{transferAmount}")
    public String makeTransfer(@PathVariable("userId") String senderId,
                               @PathVariable("receiverId") String receiverId,
                               @PathVariable("transferAmount") BigDecimal transferAmount){
        userService.transfer(senderId, receiverId, transferAmount);
        return "transfer successfully made";
    }
    @PostMapping("/changePin/{userId}/{newPin}")
    public String changePin(@PathVariable("userId") String userId,
                            @PathVariable("newPin") String newPin){
        userService.changePin(userId, newPin);
        return "pin successfully changed";
    }

}
