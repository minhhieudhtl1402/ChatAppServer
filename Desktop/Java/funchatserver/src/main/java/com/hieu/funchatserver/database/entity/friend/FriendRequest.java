/**
 * @author MinhHieu
 * @created 7/14/2023 4:47 PM
 * @project funchatserver
 */
package com.hieu.funchatserver.database.entity.friend;


import jakarta.persistence.*;

@Entity
@Table(name = "friend_request")
public class FriendRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "id_request")
    int idRequest;

    @Column(name = "id_receive")
    int idReceive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public int getIdReceive() {
        return idReceive;
    }

    public void setIdReceive(int idReceive) {
        this.idReceive = idReceive;
    }

    @Override
    public String toString() {
        return "FriendRequest{" +
                "id=" + id +
                ", idRequest=" + idRequest +
                ", idReceive=" + idReceive +
                '}';
    }
}
