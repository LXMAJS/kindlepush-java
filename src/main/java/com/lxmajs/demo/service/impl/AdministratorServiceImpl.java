package com.lxmajs.demo.service.impl;

import com.lxmajs.demo.dao.AdministratorDao;
import com.lxmajs.demo.entity.Administrator;
import com.lxmajs.demo.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdministratorServiceImpl implements AdministratorService {
    /**
     * 数据库操作类
     */
    @Autowired
    private AdministratorDao administratorDao;

    /**
     * 获得所有的管理员
     * @return
     */
    @Override
    public List<Administrator> getAdministratorList() {
        return  administratorDao.queryAdministrator();
    }

    /**
     * 获得单个管理员的信息
     * @param administratorId
     * @return
     */
    @Override
    public Administrator getAdministratorById(int administratorId) {
        return administratorDao.queryAdministratorById(administratorId);
    }

    @Override
    public boolean addAdministrator(Administrator administrator) {
        return false;
    }

    @Override
    public boolean modifyAdministrator(Administrator administrator) {
        return false;
    }

    /**
     * 删除管理员
     * @param administratorId
     * @return
     */
    @Override
    public boolean deleteAdmonistrator(int administratorId) {
        if(administratorId > 0){
            // 首先判断是否删除掉了最后一个管理员
            List<Administrator> allAdmin = administratorDao.queryAdministrator();
            if(allAdmin.size() <= 1)
                throw new RuntimeException("请至少保留1名管理员");
            // 执行删除操作
            int effectedNum = administratorDao.deleteAdministrator(administratorId);
            if(effectedNum > 0)
                return true;
            else
                throw new RuntimeException("删除管理员异常！");
        }

        // else
        throw new RuntimeException("未找到对应的管理员");
    }
}
