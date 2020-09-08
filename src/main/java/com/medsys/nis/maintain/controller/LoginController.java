package com.medsys.nis.maintain.controller; /**
 * Created by Super on 2020/8/10.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.medsys.nis.maintain.bean.User;
import com.medsys.nis.maintain.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/8/10 11:20
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(User user) {
        System.out.println("111111");

        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();

        JSONObject jsonObject = null;
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUserName(),
                user.getPassWord()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
            System.out.println(subject.getSession().getId());

            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = servletRequestAttributes.getRequest();
            HttpSession session = request.getSession();
            User attribute = (User) session.getAttribute("asd");
             jsonObject = JSONObject.parseObject(JSON.toJSONString(attribute));

//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (UnauthorizedException e){
            e.printStackTrace();
            return "没有权限";
        }catch (AuthenticationException e) {
            e.printStackTrace();
            return "账号或密码错误！";
        }
        return jsonObject.toString();
    }
    //注解验角色和权限
    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @RequestMapping("/index")
    public String index() {
        System.out.println("22222");
        return "index!";
    }

}
