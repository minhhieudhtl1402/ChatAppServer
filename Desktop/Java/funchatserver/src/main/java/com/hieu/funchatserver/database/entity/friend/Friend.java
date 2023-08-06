/**
 * @author MinhHieu
 * @created 7/14/2023 12:13 PM
 * @project funchatserver
 */
package com.hieu.funchatserver.database.entity.friend;

import jakarta.persistence.*;

@Table(name = "friend")
@Entity
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "id_send")
    int send_id ;

    @Column(name = "id_receive")
    int receive_id ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSend_id() {
        return send_id;
    }

    public void setSend_id(int send_id) {
        this.send_id = send_id;
    }

    public int getReceive_id() {
        return receive_id;
    }

    public void setReceive_id(int receive_id) {
        this.receive_id = receive_id;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", send_id=" + send_id +
                ", receive_id=" + receive_id +
                '}';
    }
}
