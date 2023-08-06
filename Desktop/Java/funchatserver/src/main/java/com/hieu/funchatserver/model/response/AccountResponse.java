/**
 * @author MinhHieu
 * @created 7/14/2023 10:51 AM
 * @project funchatserver
 */
package com.hieu.funchatserver.model.response;

import com.hieu.funchatserver.database.entity.account.UserAccount;

public class AccountResponse {
    public static final int ACCOUNT_IS_EXIST = 10400;

    public static final int ACCOUNT_IS_NOT_EXIST = 10500;
    public static final int INCORRECT_PASSWORD = 10600;
    public static final int LOGIN_SUCCESSFUL = 10700;
    public static final int SIGN_UP_SUCCESSFUL = 10800;

    private String message;
    private int status;

    private UserAccount userAccount;

    public AccountResponse(int status,UserAccount userAccount) {
        switch (status) {
            case ACCOUNT_IS_EXIST -> message = "account is exist";
            case ACCOUNT_IS_NOT_EXIST -> message = "account is not exist";
            case INCORRECT_PASSWORD -> message = "incorrect password";
            case LOGIN_SUCCESSFUL -> message = "login successful";
            case SIGN_UP_SUCCESSFUL -> message = "sign up successful";
        }
        this.message = message;
        this.status = status;
        this.userAccount=userAccount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
