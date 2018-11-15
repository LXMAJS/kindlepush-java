package com.lxmajs.demo.dao;

import com.lxmajs.demo.entity.Administrator;

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
