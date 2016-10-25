/**
 *
 */
package com.dao;

import com.model.User;

import java.util.List;

/**
 * @author Oliver.Liu
 *         DAO层泛型接口, 定义基本的DAO功能
 */
public interface IUserDAO {

    void save(User user);

    void delete(Long id);

    void delete(User user);

    void update(User user);

    User selectById(Long id);

    User selectByEmailAndPassword(String email, String password);

    User selectByUserName(String userName);

    List<User> selectUsers();
}

