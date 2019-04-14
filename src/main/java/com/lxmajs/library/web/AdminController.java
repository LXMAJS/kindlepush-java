package com.lxmajs.library.web;

import com.lxmajs.library.entity.Administrator;
import com.lxmajs.library.model.JsonResult;
import com.lxmajs.library.service.impl.AdministratorServiceImpl;
import com.lxmajs.library.web.RequestEntity.AdminUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdministratorServiceImpl administratorServiceImpl;


    /**
     * 后台管理员登录
     * @param user
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    private JsonResult adminLogin(@RequestBody AdminUser user){
        if(StringUtils.isEmpty (user.getUsername ()) || StringUtils.isEmpty (user.getPassword ()))
            return JsonResult.error ( "用户名或密码不能为空" );

        Administrator admin = administratorServiceImpl.getAdministratorByUsername ( user.getUsername () );
        if(admin == null)
            return JsonResult.error ( "用户不存在" );
        if(!admin.getPassword ().equals ( user.getPassword () ))
            return JsonResult.error ( "用户名或密码不正确" );

        return JsonResult.ok (admin);
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @RequestMapping(value = "addadmin", method = RequestMethod.POST)
    private JsonResult addAdmin(@RequestBody Administrator admin){
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
