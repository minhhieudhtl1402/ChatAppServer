package com.hieu.funchatserver.model.response;

public class ChatMessageResponse {
    public static final int TYPE_SEND = 0;
    public static final int TYPE_RECEIVE = 1;
    private String content;
    private int type;

    public ChatMessageResponse() {
    }

    ;

    public ChatMessageResponse(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
