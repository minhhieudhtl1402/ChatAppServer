/**
 * @author MinhHieu
 * @created 7/14/2023 5:02 PM
 * @project funchatserver
 */
package com.hieu.funchatserver.model.response;

public class FriendRequestResponse {
    public static final int SEND_REQUEST_SUCCESSFUL = 20200;
    public static final int SEND_REQUEST_FAILED = 20400;
    public static final int USERNAME_IS_NOT_EXIST = 20700;
    public static final int ACCEPT_REQUEST_SUCCESSFUL = 20500;
    public static final int REFUSE_REQUEST_SUCCESSFUL = 20600;
    public static final int CANCEL_SENDING_REQUEST_SUCCESSFUL = 20800;
    public static final int CANCEL_SENDING_REQUEST_FALSE = 20900;
    private String message;
    private int status;

    public FriendRequestResponse(int status) {
        switch (status) {
            case SEND_REQUEST_SUCCESSFUL -> this.message = "send request successful";
            case SEND_REQUEST_FAILED -> this.message = "send request failed";
            case ACCEPT_REQUEST_SUCCESSFUL -> this.message = "accept request successful";
            case REFUSE_REQUEST_SUCCESSFUL -> this.message = "refuse request successful";
        }
        this.status = status;
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
}
