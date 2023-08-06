/**
 * @author MinhHieu
 * @created 7/14/2023 5:32 PM
 * @project funchatserver
 */
package com.hieu.funchatserver.model.response;

import java.sql.Timestamp;

public class UserAccountResponse {
    int id;
    String name;
    Timestamp createAt;

    public UserAccountResponse(int id, String name, Timestamp createAt) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }
}
