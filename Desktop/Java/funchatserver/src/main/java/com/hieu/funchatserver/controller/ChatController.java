/**
 * @author MinhHieu
 * @created 7/18/2023 9:05 AM
 * @project funchatserver
 */
package com.hieu.funchatserver.controller;


import com.hieu.funchatserver.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    @Autowired
    ChatService chatService;

    @PostMapping("/chat/chatlist")
    Object getChatList(@RequestParam(name = "userId") int userId) {
        return chatService.getChatList(userId);
    }

    @PostMapping("chat/rownumber")
    Object getRowNumber(@RequestParam(name = "sendId") int sendId, @RequestParam(name = "receiveId") int receiveId) {
        return chatService.getRowNumber(sendId, receiveId);
    }

    @PostMapping("chat/sendnewmessage")
    Object sendNewMessage(@RequestParam(name = "sendId") int sendId, @RequestParam(name = "receiveId") int receiveId, @RequestParam(name = "content") String content) {
        return chatService.sendNewMessage(sendId, receiveId, content);
    }

    @PostMapping("chat/chatdetaillist")
    Object getChatDetailList(@RequestParam(name = "sendId") int sendId, @RequestParam(name = "receiveId") int receiveId) {
        System.out.println("Chat Detail list. SendId : " + sendId + " receiveId : " + receiveId);
        return chatService.getChatDetailList(sendId, receiveId);
    }
}

