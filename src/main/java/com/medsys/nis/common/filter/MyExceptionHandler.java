package com.medsys.nis.common.filter; /**
 * Created by Super on 2020/8/10.
 */

import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/8/10 11:22
 */
//@ControllerAdvice

public class MyExceptionHandler {
    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(MyExceptionHandler.class);
    @ExceptionHandler
    @ResponseBody
    public String ErrorHandler(AuthorizationException e) {
        System.out.println("333");
        LOG.error("没有通过权限验证！", e);
        return "没有通过权限验证！";
    }
}
