package com.lxmajs.library.service;

import com.lxmajs.library.entity.Administrator;

import java.util.List;

public interface AdministratorService {
    /**
     * 获得全部的管理员列表
     * @return
     */
    List<Administrator> getAdministratorList();

    /**
     * 获得单个管理员的信息
     * @param administratorId
     * @return
     */
    Administrator getAdministratorById(int administratorId);

    /**
     * 根据用户名获得单个管理员的信息
     * @param administratorUsername
     * @return
     */
    Administrator getAdministratorByUsername(String administratorUsername);

    /**
     * 添加管理员
     * @param administrator
     * @return
     */
    boolean addAdministrator(Administrator administrator);

    /**
     * 修改管理员的信息
     * @param administrator
     * @return
     */
    boolean modifyAdministrator(Administrator administrator);

    /**
     * 删除某个管理员
     * @param administratorId
     * @return
     */
    boolean deleteAdmonistrator(int administratorId);
}
