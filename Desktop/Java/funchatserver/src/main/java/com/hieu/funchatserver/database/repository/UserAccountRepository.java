/**
 * @author MinhHieu
 * @created 7/14/2023 10:14 AM
 * @project funchatserver
 */
package com.hieu.funchatserver.database.repository;

import com.hieu.funchatserver.database.entity.account.UserAccount;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {
    @Query(nativeQuery = true,value = "SELECT * FROM user_account")
    ArrayList<UserAccount> getAllAccount();

    UserAccount findUserAccountByUsername(String username);


    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "insert into user_account(username,password) values (:username,:password)")
    void createNewAccount(String username, String password);


//    @Query(nativeQuery = true, value = "select id,username,created_at from user_account where id=:id")
//    UserAccount findFriendById(int id);
    @Query(nativeQuery = true,value = "select * from user_account where id=:id")
    UserAccount findAccountById(int id);


//    @Query
//    UserAccount findUserAccountByUsername();
}
