package com.medsys.nis.common.aspect;

import com.medsys.nis.common.bean.RequestDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 对于所有controller的环绕切面
 *
 * @ClassName ControllerAspect
 * @Author zhuzhh
 * @Date 2020/7/16
 */
@Aspect
@Component
public class ControllerAspect {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerAspect.class);

//    //切入点
//    @Pointcut("execution(public * com.medsys.emr.*.controller.*.*(..))")
//    public void webLog() {
//
//    }
//
//    @Before("webLog()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        // 记录下请求内容
//        logger.info("URL : " + request.getRequestURL().toString());
//        logger.info("HTTP_METHOD : " + request.getMethod());
//        logger.info("IP : " + request.getRemoteAddr());
//        Enumeration<String> enu = request.getParameterNames();
//        while (enu.hasMoreElements()) {
//            String name = (String) enu.nextElement();
//            logger.info("name:{},value:{}", name, request.getParameter(name));
//        }
//    }
//
//
//    @AfterReturning(returning = "ret", pointcut = "webLog()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        // 处理完请求，返回内容
//        logger.info("RESPONSE : " + ret);
//    }


    /**
     * 后置通知
     * 用于记录所有controller的操作日志
     *
     * @param jp:切面点
     * @Author: zhuzhh
     * @Date: 2020/7/24
     * @Title: recordACT
     */
    @After("execution(public * com.medsys.emr.*.controller.*.*(..))")
    public void recordACT(JoinPoint jp) {
        Signature pjpSignature = jp.getSignature();
        if (jp.getArgs().length == 0) {
            return;
        }
        Object o = jp.getArgs()[0];
        if (o instanceof RequestDTO) {
            RequestDTO<?> requestDTO = (RequestDTO<?>) jp.getArgs()[0];
            LOG.info("操作者ip:{},操作者编码:{},操作者名称:{},目标Controller:{},目标接口:{},接口版本:{}",
                    requestDTO.getIp(), requestDTO.getOperCode(), requestDTO.getOperName(),
                    pjpSignature.getDeclaringTypeName(), pjpSignature.getName(), requestDTO.getVer());
        }
    }

}
