package com.sf.xx.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
// 只能写在方法上
@Target({ElementType.METHOD})
// 运行时有效可以通过反射获取
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogInfoPut 
{
	/**
	 * 日志的信息
	 * @return
	 */
	String message() default "";
	
	/**
	 * 日志的类型
	 * @return
	 */
	LoggerType type() default LoggerType.Operation;
}
