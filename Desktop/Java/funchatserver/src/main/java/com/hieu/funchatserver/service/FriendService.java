/**
 * @author MinhHieu
 * @created 7/14/2023 4:40 PM
 * @project funchatserver
 */
package com.hieu.funchatserver.service;

import com.hieu.funchatserver.database.entity.account.UserAccount;
import com.hieu.funchatserver.database.entity.friend.FriendRequest;
import com.hieu.funchatserver.database.repository.FriendRepository;
import com.hieu.funchatserver.database.repository.FriendRequestRepository;
import com.hieu.funchatserver.database.repository.UserAccountRepository;
import com.hieu.funchatserver.model.response.FriendRequestResponse;
import com.hieu.funchatserver.model.response.SendingRequestResponse;
import com.hieu.funchatserver.model.response.UserAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FriendService {

    @Autowired
    FriendRepository friendRepository;

    @Autowired
    FriendRequestRepository friendRequestRepository;

    @Autowired
    UserAccountRepository userAccountRepository;

    public Object getAllFriend(int id) {
        return friendRepository.getAllFriend(id);
    }

    public Object requestFriend(int requestId, int receiveId) {
        friendRequestRepository.sendNewRequest(requestId, receiveId);
        return new FriendRequestResponse(FriendRequestResponse.SEND_REQUEST_SUCCESSFUL);
    }


    public ArrayList<UserAccountResponse> getAllFriendRequest(int receiveId) {

        ArrayList<Integer> friendIndexs = friendRequestRepository.getAllFriendRequestById(receiveId);
        ArrayList<UserAccountResponse> friends = new ArrayList<>();
        for (int item : friendIndexs) {
            UserAccount account = userAccountRepository.findAccountById(item);
            UserAccountResponse user = new UserAccountResponse(account.getId(), account.getUsername(), account.getCreateAt());
            friends.add(user);
        }
        return friends;
    }

    public Object acceptFriendRequest(int receiveId, int requestId) {
        friendRequestRepository.deleteFriendRequest(receiveId, requestId);
        friendRepository.addNewRecord(requestId, receiveId);
        return new FriendRequestResponse(FriendRequestResponse.ACCEPT_REQUEST_SUCCESSFUL);
    }

    public Object refuseFriendRequest(int receiveId, int requestId) {
        friendRequestRepository.deleteFriendRequest(receiveId, requestId);
        return new FriendRequestResponse(FriendRequestResponse.REFUSE_REQUEST_SUCCESSFUL);
    }

    public Object requestWithName(int requestId, String name) {
        UserAccount receiveAccount = userAccountRepository.findUserAccountByUsername(name);
        UserAccount requestAccount = userAccountRepository.findAccountById(requestId);
        if (receiveAccount == null) {
            return new FriendRequestResponse(FriendRequestResponse.USERNAME_IS_NOT_EXIST);
        } else {
            if (receiveAccount.getUsername() != requestAccount.getUsername()) {
                if ((friendRequestRepository.countRequest(receiveAccount.getId(), requestAccount.getId()) == 0)
                        &&
                        (friendRepository.countFriendRecord(receiveAccount.getId(), requestAccount.getId()) == 0)) {
                    int id_send = requestAccount.getId();
                    int id_receive = receiveAccount.getId();
                    friendRequestRepository.sendNewRequest(id_send, id_receive);
                    return new FriendRequestResponse(FriendRequestResponse.SEND_REQUEST_SUCCESSFUL);
                } else {
                    return new FriendRequestResponse(FriendRequestResponse.SEND_REQUEST_FAILED);
                }

            } else {
                return new FriendRequestResponse(FriendRequestResponse.SEND_REQUEST_FAILED);
            }
        }
    }


    public Object getAllSendRequestInfo(int requestId) {
        ArrayList<FriendRequest> friendRequests = friendRequestRepository.getListRequest(requestId);
        if (friendRequests.size() > 0) {
            ArrayList<SendingRequestResponse> sendingRequestRespons = new ArrayList<>();
            for (FriendRequest item : friendRequests) {
                SendingRequestResponse sendingRequestResponse = new SendingRequestResponse();
                sendingRequestResponse.setId(item.getIdReceive());
                String receive_name = userAccountRepository.findAccountById(item.getIdReceive()).getUsername();
                sendingRequestResponse.setName(receive_name);
                sendingRequestRespons.add(sendingRequestResponse);
            }
            return sendingRequestRespons;
        } else return new ArrayList<SendingRequestResponse>();
    }

    public Object cancelSendingRequest(int receiveId, int requestId) {
        int value = friendRequestRepository.deleteFriendRequest(receiveId, requestId);
        if (value == FriendRequestResponse.CANCEL_SENDING_REQUEST_SUCCESSFUL) {
            return new FriendRequestResponse(FriendRequestResponse.CANCEL_SENDING_REQUEST_SUCCESSFUL);
        } else {
            return new FriendRequestResponse(FriendRequestResponse.CANCEL_SENDING_REQUEST_FALSE);
        }
    }


}
