package com.lxmajs.demo.service.impl;

import com.lxmajs.demo.dao.AdministratorDao;
import com.lxmajs.demo.entity.Administrator;
import com.lxmajs.demo.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
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

    /**
     * 根据用户名获得单个管理员的信息
     * @param administratorUsername
     * @return
     */
    @Override
    public Administrator getAdministratorByUsername(String administratorUsername) {
        return administratorDao.queryAdministratorByUsername(administratorUsername);
    }

    @Override
    public boolean addAdministrator(Administrator administrator) {
        // 业务判断
        if(administrator.getUsername() != null && !"".equals(administrator.getUsername())
                && (administrator.getNickname() != null && !"".equals(administrator.getNickname()))
                && (administrator.getPassword() != null && !"".equals(administrator.getPassword()))
                && (administrator.getRoleType() >= Administrator.ERoleType.DefaultRolt.getCode())) {
            // 设置开始时间
            administrator.setCreateTime(new Date());
            try {
                int effectedNum = administratorDao.insertAdministrator(administrator);
                if(effectedNum > 0)
                    return true;
                else
                    throw new RuntimeException("团加管理员异常！");

            } catch (Exception e) {
                throw new RuntimeException("添加管理员失败：" + e.getMessage());
            }
        }

        // else
        throw new RuntimeException("管理员信息不完整！");
    }

    @Override
    public boolean modifyAdministrator(Administrator administrator) {
        // 业务判断
        if(isFill(administrator)) {
            try {
                int effectedNum = administratorDao.updateAdministrator(administrator);
                if(effectedNum > 0)
                    return true;
                else
                    throw new RuntimeException("更新管理员异常！");

            } catch (Exception e) {
                throw new RuntimeException("更新管理员失败：" + e.getMessage());
            }
        }

        // else
        throw new RuntimeException("管理员信息不完整！");
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

    /**
     * 判断管理员信息是否完整
     * @param administrator
     * @return
     */
    public boolean isFill(Administrator administrator){
        boolean fill = administrator.getUsername() != null && !"".equals(administrator.getUsername())
                && (administrator.getNickname() != null && !"".equals(administrator.getNickname()))
                && (administrator.getPassword() != null && !"".equals(administrator.getPassword()))
                && (administrator.getRoleType() >= Administrator.ERoleType.DefaultRolt.getCode());

        return fill;
    }
}
