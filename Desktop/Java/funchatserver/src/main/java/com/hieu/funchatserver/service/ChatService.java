/**
 * @author MinhHieu
 * @created 7/18/2023 9:04 AM
 * @project funchatserver
 */
package com.hieu.funchatserver.service;


import com.hieu.funchatserver.database.entity.account.UserAccount;
import com.hieu.funchatserver.database.entity.chat.Chat;
import com.hieu.funchatserver.database.entity.friend.Friend;
import com.hieu.funchatserver.database.repository.ChatRepository;
import com.hieu.funchatserver.database.repository.FriendRepository;
import com.hieu.funchatserver.database.repository.UserAccountRepository;
import com.hieu.funchatserver.model.response.ChatMessageResponse;
import com.hieu.funchatserver.model.response.ChatResponse;
import com.hieu.funchatserver.model.response.SendMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

@Service
public class ChatService {
    @Autowired
    ChatRepository chatRepository;

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    FriendRepository friendRepository;

    public Object getChatList(int userId) {
        ArrayList<Friend> friends = friendRepository.getAllFriend(userId);
        ArrayList<ChatResponse> chatResponses = new ArrayList<>();
        for (Friend item : friends) {
            System.out.println("ChatService/ChatList Friend id: " + item);
            ChatResponse chatResponse = new ChatResponse();
            int receiveId;
            if (item.getSend_id() == userId) {
                receiveId = item.getReceive_id();
                chatResponse.setReceiveId(receiveId);
            } else {
                receiveId = item.getSend_id();
                chatResponse.setReceiveId(receiveId);
            }
            UserAccount userAccount = userAccountRepository.findAccountById(receiveId);
            String name = userAccount.getUsername();

            int numRow = chatRepository.getChatRow(userId, receiveId);
            Chat lastMessage;
            String formattedCreateAt;
            if (numRow == 0) {
                lastMessage = new Chat();
            } else {
                lastMessage = chatRepository.getLastMessage(userId, receiveId);

            }
            chatResponse.setName(name);
            System.out.println("ChatService/Last Message :" + lastMessage.toString());
            chatResponse.setContent(lastMessage.getContent());

            if (lastMessage.getCreateAt() != null) {
                formattedCreateAt = new SimpleDateFormat("HH:mm").format(lastMessage.getCreateAt());
            } else {
                formattedCreateAt = "";
            }
            chatResponse.setCreateAt(formattedCreateAt);
            chatResponse.setType(lastMessage.getType());
            chatResponses.add(chatResponse);
        }
        for (int i = 0; i < chatResponses.size(); i++) {
            System.out.println(chatResponses.get(i).toString());
        }
        chatResponses.sort(new Comparator<ChatResponse>() {
            @Override
            public int compare(ChatResponse o1, ChatResponse o2) {
                return o2.getCreateAt().compareTo(o1.getCreateAt());
            }
        });
        return chatResponses;
    }

    public Object getRowNumber(int sendId, int receiveId) {
        return chatRepository.getChatRow(sendId, receiveId);
    }

    public Object sendNewMessage(int sendId, int receiveId, String content) {
        chatRepository.sendNewMessage(sendId, receiveId, content);
        return new SendMessageResponse("Successful", SendMessageResponse.SEND_SUCCESSFUL);
    }

    public Object getChatDetailList(int sendId, int receiveId) {
        ArrayList<Chat> chatLists = chatRepository.getDetailChatList(sendId, receiveId);
        ArrayList<ChatMessageResponse> chatMessageResponses = new ArrayList<>();
        for (Chat item : chatLists) {
            ChatMessageResponse chatMessageResponse = new ChatMessageResponse();
            if (item.getSendId() == sendId) {
                chatMessageResponse.setType(ChatMessageResponse.TYPE_SEND);
                chatMessageResponse.setContent(item.getContent());
            } else if (item.getSendId() == receiveId) {
                chatMessageResponse.setType(ChatMessageResponse.TYPE_RECEIVE);
                chatMessageResponse.setContent(item.getContent());
            }
            chatMessageResponses.add(chatMessageResponse);
        }

        return chatMessageResponses;
    }
}
