/**
 *
 */
package com.service;

import com.model.User;

import java.util.List;

/**
 * @author Oliver.Liu
 */
public interface IUserService {
    void addUser(User user);

    void removeUser(Long id);

    void removeUser(User user);

    void modifyUser(User user);

    User findById(Long id);

    User findByEmailAndPassword(String email, String password);

    User findUserByUsername(String userName);

    List<User> findUsers();
}
