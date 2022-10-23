package org.scau.mall.config.datasource;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Aspect
@Component
public class DataSourceAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(DataSourceAdvice.class);
	
	/**
	 * 定义切点，含有Datasource注解或org.scau.mall.service的类
	 */
	@Pointcut("execution(* org.scau.mall.service.*.*(..)) || @annotation(org.scau.mall.config.datasource.DataSource)")
	public void aspect(){
		
	}
	
	@Before("aspect()")
    public void beforeAdvice(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		DataSourceType dbType = null;
		Annotation[] annotations = method.getAnnotations();
		if(StringUtils.isEmpty(annotations)) {
			DataSourceSwitch.setDbType(dbType);
			return ;
		}
		String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        //记录方法上的数据源注解类型,并设置到ThreadLocal中
		for(Annotation annotation : annotations) {
			if(DataSource.class.isInstance(annotation)) {
				dbType = ((DataSource)annotation).dataSource();
				DataSourceSwitch.setDbType(dbType);
				if(logger.isDebugEnabled()){
					logger.debug("AOP> class: {}, method: {}, current method datasource: {}, final use datasource: {}", className, methodName, dbType, DataSourceType.valueOfDataSource(DataSourceSwitch.getDbType()));
            	}
                return;
			}
		}
		//方法上没有标识数据源类型的注解时采用默认数据源类型
        DataSourceSwitch.setDbType(dbType);
	}
	
	@After("aspect()")
    public void afterAdvice(JoinPoint joinPoint) {
		//方法执行结束，删除其数据源标识
		DataSourceSwitch.popDbType();
	}

}
