/**
 * @author MinhHieu
 * @created 7/14/2023 12:27 PM
 * @project funchatserver
 */
package com.hieu.funchatserver.database.repository;

import com.hieu.funchatserver.database.entity.friend.Friend;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM friend where id_send=:id or id_receive=:id")
    ArrayList<Friend> getAllFriend(int id);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into friend (id_send,id_receive) values (:requestId,:receiveId)")
    void addNewRecord(int requestId, int receiveId);

    @Query(nativeQuery = true, value = "SELECT count(*) from friend where (id_send=:requestId and id_receive=:receiveId ) or (id_send=:receiveId and id_receive=:requestId)")
    int countFriendRecord(int requestId, int receiveId);
}
