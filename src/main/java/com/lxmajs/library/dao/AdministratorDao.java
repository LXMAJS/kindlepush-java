package com.lxmajs.library.dao;

import com.lxmajs.library.entity.Administrator;

import java.util.List;


public interface AdministratorDao {

    /**
     *
     * @return
     */
    List<Administrator> queryAdministrator();

    /**
     *
     * @param id
     * @return
     */
    Administrator queryAdministratorById(int id);

    /**
     * 根据用户名获得某个用户的信息
     * @param username
     * @return
     */
    Administrator queryAdministratorByUsername(String username);

    /**
     *
     * @param admin
     * @return
     */
    int insertAdministrator(Administrator admin);

    /**
     *
     * @param admin
     * @return
     */
    int updateAdministrator(Administrator admin);

    /**
     *
     * @param administratorId
     * @return
     */
    int deleteAdministrator(int administratorId);
}
