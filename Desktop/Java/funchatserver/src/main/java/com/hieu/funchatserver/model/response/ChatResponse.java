/**
 * @author MinhHieu
 * @created 7/18/2023 9:18 AM
 * @project funchatserver
 */
package com.hieu.funchatserver.model.response;

import java.sql.Timestamp;

public class ChatResponse {
    int receiveId;
    String name;

    String content;

    String type;

    String createAt;

    public int getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(int receiveId) {
        this.receiveId = receiveId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "ChatResponse{" +
                "receiveId=" + receiveId +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
