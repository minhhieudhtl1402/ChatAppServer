/**
 * @author MinhHieu
 * @created 7/18/2023 9:07 AM
 * @project funchatserver
 */
package com.hieu.funchatserver.database.repository;


import com.hieu.funchatserver.database.entity.chat.Chat;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM chat where id_send=:userId")
    ArrayList<Chat> getChatList(int userId);


    @Query(nativeQuery = true, value = "SELECT * FROM  chat where (id_send=:sendId and id_receive=:receiveId) or (id_send=:receiveId and id_receive=:sendId) order by create_at desc limit 1")
    Chat getLastMessage(int sendId, int receiveId);

    @Query(nativeQuery = true, value = "SELECT count(*) from chat where id_send=:sendId and id_receive=:receiveId")
    int getChatRow(int sendId, int receiveId);


    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "INSERT INTO chat(id_send,id_receive,content,type,create_at) values (:sendId,:receiveId,:content,'text',current_timestamp)")
    Object sendNewMessage(int sendId, int receiveId, String content);



    @Query(nativeQuery = true,value = "SELECT * from chat where (id_send=:userId and id_receive=:receiveId) or(id_send=:receiveId and id_receive=:userId) order by create_at DESC ")
    ArrayList<Chat> getDetailChatList(int userId,int receiveId);
}
