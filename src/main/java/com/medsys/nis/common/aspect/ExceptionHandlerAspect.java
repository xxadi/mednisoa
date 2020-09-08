package com.medsys.nis.common.aspect;

import com.medsys.nis.common.bean.ResponseDTO;
import com.medsys.nis.common.config.ConfigData;
import com.medsys.nis.common.config.ResultDetailEnum;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * controller全局异常处理
 *
 * @ClassName ExceptionHandlerAspect
 * @Author zhuzhh
 * @Date 2020/7/21
 */
@ControllerAdvice
public class ExceptionHandlerAspect {
    /**
     * 日志操作
     */
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlerAspect.class);

    /**
     * 对controller层被抛出的异常进行捕获
     *
     * @param e 异常内容
     * @return ResponseBean<Object>
     * @Author zhuzhh
     * @Date 2020/7/21
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResponseDTO<Object> exceptionHandle(Exception e) {
        if(e instanceof AuthorizationException){
            LOG.error("没有通过权限验证！", e);
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, "xxx", ResultDetailEnum.SERVER_ERROR, "没有通过权限验证");

        }
        else {
            LOG.error("服务端发生异常，请进行排查", e);
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, "xxx", ResultDetailEnum.SERVER_ERROR, "服务端发生异常，请进行排查");

        }
    }
}
