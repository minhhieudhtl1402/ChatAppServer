/**
 * @author MinhHieu
 * @created 7/18/2023 9:08 AM
 * @project funchatserver
 */
package com.hieu.funchatserver.database.entity.chat;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "id_send")
    int sendId;

    @Column(name = "id_receive")
    int receiveId;

    @Column(name = "content")
    String content="";

    @Column(name = "type")
    String type;

    @Column(name = "create_at")
    Timestamp createAt;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSendId() {
        return sendId;
    }

    public void setSendId(int sendId) {
        this.sendId = sendId;
    }

    public int getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(int receiveId) {
        this.receiveId = receiveId;
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

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", sendId=" + sendId +
                ", receiveId=" + receiveId +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", createAt='" + createAt + '\'' +
                '}';
    }


}
