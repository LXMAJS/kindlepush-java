package com.lxmajs.demo.service;

import com.lxmajs.demo.entity.User;

import java.util.List;

public interface UserService {

    /**
     *
     * @param userName
     * @return
     */
    User getUserByUsername(String userName);
    /**
     *
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     *
     * @param user
     * @return
     */
    boolean modifyUser(User user);

    /**
     *
     * @param userId
     * @return
     */
    boolean deleteBook(int userId);
}
