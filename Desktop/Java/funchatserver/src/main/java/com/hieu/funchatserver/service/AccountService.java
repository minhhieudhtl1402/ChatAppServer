/**
 * @author MinhHieu
 * @created 7/14/2023 10:13 AM
 * @project funchatserver
 */
package com.hieu.funchatserver.service;

import com.hieu.funchatserver.database.entity.account.UserAccount;
import com.hieu.funchatserver.model.response.AccountResponse;
import com.hieu.funchatserver.database.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AccountService {
    @Autowired
    UserAccountRepository userAccountRepository;

    public ArrayList<UserAccount> getAllAccount() {
        return userAccountRepository.getAllAccount();
    }

    public Object login(String name, String pass) {
        UserAccount userAccount = userAccountRepository.findUserAccountByUsername(name);
        if (userAccount == null) {
            return new AccountResponse(AccountResponse.ACCOUNT_IS_NOT_EXIST, null);
        } else {
            if (!pass.equals(userAccount.getPassword())) {
                return new AccountResponse(AccountResponse.INCORRECT_PASSWORD, null);
            } else {
                return new AccountResponse(AccountResponse.LOGIN_SUCCESSFUL, userAccount);
            }
        }
    }

    public Object isAccountExist(String username) {
        UserAccount userAccount = userAccountRepository.findUserAccountByUsername(username);
        if (userAccount != null) {
            return new AccountResponse(AccountResponse.ACCOUNT_IS_EXIST, null);
        } else {
            return new AccountResponse(AccountResponse.ACCOUNT_IS_NOT_EXIST, null);
        }
    }


    public Object signUp(String username, String password) {
        UserAccount userAccount = userAccountRepository.findUserAccountByUsername(username);
        if (userAccount != null) {
            return new AccountResponse(AccountResponse.ACCOUNT_IS_EXIST, null);
        } else {
            userAccountRepository.createNewAccount(username, password);
            return new AccountResponse(AccountResponse.SIGN_UP_SUCCESSFUL, null);
        }
    }
}
