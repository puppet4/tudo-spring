/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework.test;

import com.tudo.springframework.BeanDefinition;
import com.tudo.springframework.BeanFactory;
import com.tudo.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2021/12/17 4:19 下午
 * @Version:1.0.0
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        //1、初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        //2、注册bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("UserService", beanDefinition);

        //3、获取bean
        UserService userService = (UserService) beanFactory.getBean("UserService");
        userService.queryUserInfo();
    }
}