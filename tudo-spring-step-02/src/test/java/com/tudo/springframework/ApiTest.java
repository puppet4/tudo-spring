/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework;

import com.tudo.springframework.beans.factory.config.BeanDefinition;
import com.tudo.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2021/12/28 10:57 上午
 * @Version:1.0.0
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        //1、初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //2、注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //3、第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        //4、第二次获取bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getSingleton("userService");
        userService_singleton.queryUserInfo();
    }

    /**
     * 功能描述: 验证有参数构造函数初始化异常<br>
     *
     * @return: void
     * @since: 1.0.0
     * @author: lvkj@tsintergy.com
     * @date: 2021/12/28 1:45 下午
     */
    @Test
    public void test_BeanFactoryStudent() {
        //1、初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //2、注册bean
        BeanDefinition beanDefinition = new BeanDefinition(StudentService.class);
        beanFactory.registerBeanDefinition("studentService", beanDefinition);
        //3、第一次获取bean
        StudentService studentService = (StudentService) beanFactory.getBean("studentService");
    }
}