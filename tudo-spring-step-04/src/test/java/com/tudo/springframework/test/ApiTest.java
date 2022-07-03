/**
 * Copyright(C),2015‐2022,北京清能互联科技有限公司
 */
package com.tudo.springframework.test;

import com.tudo.springframework.beans.PropertyValue;
import com.tudo.springframework.beans.PropertyValues;
import com.tudo.springframework.beans.config.BeanDefinition;
import com.tudo.springframework.beans.config.BeanReference;
import com.tudo.springframework.beans.support.DefaultListableBeanFactory;
import com.tudo.springframework.test.beans.UserDao;
import com.tudo.springframework.test.beans.UserService;
import org.testng.annotations.Test;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2022/6/24 13:56
 * @Version:1.0.0
 */
public class ApiTest {


    @Test
    public void test_BeanFactory() {
        //1、初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //2、UserDao注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        //3、UserService设置属性【uId、userDao】
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "1001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        //4、UserService注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //5、UserSerevice获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}