package com.lxmajs.demo.web;

import com.lxmajs.demo.dao.AdministratorDao;
import com.lxmajs.demo.entity.Administrator;
import com.lxmajs.demo.model.JsonResult;
import com.lxmajs.demo.model.WXSessionModel;
import com.lxmajs.demo.service.impl.AdministratorServiceImpl;
import com.lxmajs.demo.util.HttpClientUtil;
import com.lxmajs.demo.util.JsonUtil;
import com.lxmajs.demo.util.RedisOperator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdministratorServiceImpl administratorServiceImpl;

    /**
     * 后台管理员登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    private JsonResult adminLogin(String username, String password){
        if(!StringUtils.isBlank(username) && !StringUtils.isBlank(password)){
            Administrator admin = administratorServiceImpl.getAdministratorByUsername(username);
            //TODO: 此处需要考虑使用加密算法针对用户名和密码做进一步的处理
            // 为了方便快速，就指节比较密码是否匹配了，不做进一步的处理了
            if(!StringUtils.equals(admin.getPassword(), password)){
                return JsonResult.error("密码不正确！");
            } else {
                return JsonResult.ok();
            }
        }
        return JsonResult.error("请填写完整的用户名和密码");
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @RequestMapping(value = "addadmin", method = RequestMethod.POST)
    private JsonResult addAdmin(Administrator admin){
        if(!administratorServiceImpl.isFill(admin))
            return JsonResult.error("请补充必要信息");

        boolean result = administratorServiceImpl.addAdministrator(admin);
        if(result){
            Administrator newAdmin = administratorServiceImpl.getAdministratorByUsername(admin.getUsername());
            if(newAdmin != null)
                return JsonResult.ok(newAdmin);
        }

        return JsonResult.error("添加管理员失败！");
    }
}
