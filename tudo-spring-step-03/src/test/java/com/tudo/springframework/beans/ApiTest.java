/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans;

import com.tudo.springframework.beans.factory.config.BeanDefinition;
import com.tudo.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2021/12/28 3:03 下午
 * @Version:1.0.0
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 注入 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService", "测试用户");
        userService.queryUserInfo();
    }

}