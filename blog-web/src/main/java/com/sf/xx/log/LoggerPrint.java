package com.sf.xx.log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * logger切面
 * @author admin
 *
 */
@Aspect
@Component
public class LoggerPrint
{
	/**
	 * 日志打印
	 */
	private static final Logger LOG = LoggerFactory.getLogger(LoggerPrint.class);
	
	/**
	 * 声明切点
	 */
	@Pointcut("@annotation(com.sf.xx.log.LogInfoPut)")
	public void annotationPonitCut()
	{
		
	}
	
	/**
	 * 后置通知
	 * @param joinPoint
	 */
	@After(value="annotationPonitCut()")
    public void after(JoinPoint joinPoint)
    {
	    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        LogInfoPut loginPut = signature.getMethod().getAnnotation(LogInfoPut.class);
        String message = loginPut.message();
        if (LOG.isInfoEnabled())
        {
        	LOG.info(message);
        }
    }
	
	@AfterThrowing(value="annotationPonitCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e)
	{  
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        LogInfoPut loginPut = signature.getMethod().getAnnotation(LogInfoPut.class);
        String message = loginPut.message();
        if (LOG.isErrorEnabled())
        {
        	LOG.error(message + e.getMessage(), e);
        }
    }  
	
}
