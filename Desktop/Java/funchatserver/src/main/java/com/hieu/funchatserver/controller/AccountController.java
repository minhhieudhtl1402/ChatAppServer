/**
 * @author MinhHieu
 * @created 7/14/2023 10:12 AM
 * @project funchatserver
 */
package com.hieu.funchatserver.controller;


import com.hieu.funchatserver.database.entity.account.UserAccount;
import com.hieu.funchatserver.service.AccountService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController()
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/account/all")
    ArrayList<UserAccount> getAllAccount() {
        return accountService.getAllAccount();
    }

    @PostMapping("account/checkexist")
    Object checkExist(@RequestParam(name = "username") String username) {
        return accountService.isAccountExist(username);
    }

    @PostMapping("/account/login")
    Object login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        System.out.println("Sign in  " + username +" " + password);
        return accountService.login(username, password);
    }

    @PostMapping("/account/signup")
    Object signUp(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        System.out.println(username + " " +password + " sign up");
        return accountService.signUp(username,password);
    }


}
