package com.hieu.funchatserver.model.response;

public class SendMessageResponse {
    public static final int SEND_SUCCESSFUL = 1;
    public static final int SEND_FAILED = 0;
    private String message = "";
    private int status = 0;

    public SendMessageResponse(String message, int status) {
        this.message = message;
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
