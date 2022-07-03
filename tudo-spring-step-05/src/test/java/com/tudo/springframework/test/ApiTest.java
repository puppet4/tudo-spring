/**
 * Copyright(C),2015‐2022,北京清能互联科技有限公司
 */
package com.tudo.springframework.test;

import cn.hutool.core.io.IoUtil;
import com.tudo.springframework.beans.PropertyValue;
import com.tudo.springframework.beans.PropertyValues;
import com.tudo.springframework.beans.factory.config.BeanDefinition;
import com.tudo.springframework.beans.factory.config.BeanReference;
import com.tudo.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.tudo.springframework.beans.factory.support.XmlBeanDefinitionReader;
import com.tudo.springframework.core.io.DefaultResourceLoader;
import com.tudo.springframework.core.io.Resource;
import com.tudo.springframework.test.beans.UserDao;
import com.tudo.springframework.test.beans.UserService;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Before;
import org.junit.Test;

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


    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }


    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource(
            "https://github.com/puppet4/tudo-spring/blob/master/tudo-spring-step-05/src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        //1、初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2、读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        //3、获取Bean对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();

    }
}