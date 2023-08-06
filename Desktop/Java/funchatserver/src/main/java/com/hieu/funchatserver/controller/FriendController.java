/**
 * @author MinhHieu
 * @created 7/14/2023 12:32 PM
 * @project funchatserver
 */
package com.hieu.funchatserver.controller;


import com.hieu.funchatserver.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController()
public class FriendController {
    @Autowired
    FriendService friendService;

    @PostMapping("/friend/all")
    Object getAllFriend(@RequestParam(name = "id") int id) {
        return friendService.getAllFriend(id);
    }

    @PostMapping("friend/request")
    Object requestFriend(@RequestParam(name = "requestId") int requestId, @RequestParam(name = "receiveId") int receiveId) {
        return friendService.requestFriend(requestId, receiveId);
    }

    @PostMapping("/friend/friendrequest")
    Object getAllFriendRequest(@RequestParam(name = "receiveId") int receiveId) {
        return friendService.getAllFriendRequest(receiveId);
    }

    @PostMapping("/friend/acceptrequest")
    Object acceptFriendRequest(@RequestParam(name = "receiveId") int receiveId, @RequestParam(name = "requestId") int requestId) {
        return friendService.acceptFriendRequest(receiveId, requestId);
    }

    @PostMapping("/friend/removerequest")
    Object removeFriendRequest(@RequestParam(name = "receiveId") int receiveId, @RequestParam(name = "requestId") int requestId) {
        System.out.println("Refuse receiveId " + receiveId + " requestId " + requestId);
        return friendService.refuseFriendRequest(receiveId, requestId);
    }

    @PostMapping("/friend/requestFriendWithName")
    Object requestFriendWithName(@RequestParam(name = "requestId") int requestId, @RequestParam(name = "name") String name) {
        System.out.println("Request " + requestId + " with name " + name);
        return friendService.requestWithName(requestId, name);
    }

    @PostMapping("/friend/getAllSendingRequest")
    Object getAllSendRequestInfo(@RequestParam(name = "requestId") int requestId) {
        System.out.println("Request " + requestId);
        return friendService.getAllSendRequestInfo(requestId);
    }

    @PostMapping("/friend/cancelSendingRequest")
    Object cancelSendingRequest(@RequestParam(name = "receiveId") int receiveId, @RequestParam(name = "requestId") int requestId) {
        System.out.println("cancel sending request  " + " requestId " + requestId + " receiveId " + receiveId);
        return friendService.cancelSendingRequest(receiveId, requestId);
    }

}
