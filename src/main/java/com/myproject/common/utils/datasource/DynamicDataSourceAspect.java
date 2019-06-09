package com.myproject.common.untils.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Order(-10) // 保证该Aop在@Transaction之前执行
@Component
public class DynamicDataSourceAspect {
    public static final Logger log = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    /**
     * @Before("@annotation(ds)") 的意思是：
     * @Before：在方法执行之前进行执行：
     * @annotation(targetDataSource)： 会拦截注解targetDataSource的方法，否则不拦截;
     */
    @Before("@annotation(targetDataSource)")
    public void changDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
        String dataSource = DynamicDataSourceContextHolder.DEFAULT_DATASOURCE;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@TargetDataSource注解
            if (method.isAnnotationPresent(TargetDataSource.class)) {
                TargetDataSource annotation = method.getAnnotation(TargetDataSource.class);
                // 取出注解中的数据源名
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 切换数据源
        log.info("数据源切换：" + dataSource + "==>" + point.getSignature());
        DynamicDataSourceContextHolder.setDataSourceType(dataSource);
    }

    @After("@annotation(targetDataSource)")
    public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        log.info("数据源切回默认模式：" + targetDataSource.value() + "==>" + point.getSignature());
        //方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
}
