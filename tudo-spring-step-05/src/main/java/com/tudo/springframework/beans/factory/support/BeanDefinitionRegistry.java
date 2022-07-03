package com.tudo.springframework.beans.factory.support;

import com.tudo.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    /**
     * 功能描述:向注册表中注册 BeanDefinition <br>
     *
     * @param beanName beanName
     * @param beanDefinition beanDefinition
     * @return: void
     * @since: 1.0.0
     * @author: lvkj@tsintergy.com
     * @date: 2022/6/25 20:44
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 功能描述: 判断是否包含指定名称的BeanDefinition<br>
     *
     * @param beanName beanName
     * @return: boolean
     * @since: 1.0.0
     * @author: lvkj@tsintergy.com
     * @date: 2022/6/25 20:44
     */
    boolean containsBeanDefinition(String beanName);
}