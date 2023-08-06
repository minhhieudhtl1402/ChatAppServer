/**
 * @author MinhHieu
 * @created 7/14/2023 10:12 AM
 * @project funchatserver
 */
package com.hieu.funchatserver.database.entity.account;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "user_account")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "username")
    String username;

    String password;

    @Column(name = "created_at")
    Timestamp createAt;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
