/**
 *
 */
package com.service.impl;

import com.dao.IUserDAO;
import com.model.User;
import com.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Oliver.Liu
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDAO userDAO;

    @Override
    public void addUser(User user) {
        this.userDAO.save(user);
    }

    @Override
    public void removeUser(Long id) {
        this.userDAO.delete(id);
    }

    @Override
    public void removeUser(User user) {
        this.userDAO.delete(user);
    }

    @Override
    public void modifyUser(User user) {
        this.userDAO.save(user);
    }

    @Override
    public User findById(Long id) {
        return this.userDAO.selectById(id);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return this.userDAO.selectByEmailAndPassword(email, password);
    }

    @Override
    public User findUserByUsername(String userName) {
        return this.userDAO.selectByUserName(userName);
    }

    @Override
    public List<User> findUsers() {
        return this.userDAO.selectUsers();
    }
}
