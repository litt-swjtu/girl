package com.swjtu.girl.aspect;

import com.swjtu.girl.Exception.GirlException;
import com.swjtu.girl.enums.ResultEnum;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 李天峒
 * @date 2019/1/22 20:29
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**  ..表示无论函数里面是什么参数，都会被拦截 */

    /**
     * 此方法是公用的，用来统一管理拦截的请求
     *  *表示所有的方法都给拦截
     */
    @Pointcut("execution(public * com.swjtu.girl.controller.GirlController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Exception{
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        if(!("login").equals(request.getHeader("Authorization"))) {
            System.out.println(request.getHeader("Authorization"));
            throw new GirlException(ResultEnum.UNLOGIN);
        }

        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //param
        logger.info("param={}",joinPoint.getArgs());

        logger.info("111111");
    }

    @After("log()")
    public void doAfter() {
        logger.info("22222");
    }

    @AfterReturning(returning = "object" ,pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
