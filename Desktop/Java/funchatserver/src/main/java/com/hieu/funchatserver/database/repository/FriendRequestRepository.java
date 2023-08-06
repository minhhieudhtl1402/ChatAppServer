/**
 * @author MinhHieu
 * @created 7/14/2023 4:49 PM
 * @project funchatserver
 */
package com.hieu.funchatserver.database.repository;

import com.hieu.funchatserver.database.entity.friend.FriendRequest;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, Integer> {


    @Query(nativeQuery = true, value = "SELECT id_request FROM friend_request where id_receive=:receiveId")
    ArrayList<Integer> getAllFriendRequestById(int receiveId);

    @Query(nativeQuery = true, value = "SELECT id_receive FROM friend_request where id_request=:requestId")
    ArrayList<Integer> getAllSentRequestById(int requestId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into friend_request (id_request,id_receive) values (:requestId,:receiveId)")
    void sendNewRequest(int requestId, int receiveId);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete from friend_request where id_receive=:receiveId and  id_request=:requestId ")
    int deleteFriendRequest(int receiveId, int requestId);

    @Query(nativeQuery = true, value = "select count(*) from friend_request where (id_receive=:receiveId and id_request=:requestId) or (id_receive=:requestId and id_request=:receiveId) ")
    int countRequest(int receiveId, int requestId);

    @Query(nativeQuery = true,value = "select * from friend_request where id_request=:requestId")
    ArrayList<FriendRequest> getListRequest(int requestId);

}
