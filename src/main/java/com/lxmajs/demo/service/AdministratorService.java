package com.lxmajs.demo.service;

import com.lxmajs.demo.entity.Administrator;

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
