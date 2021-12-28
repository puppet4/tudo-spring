/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans.factory.support;

import com.tudo.springframework.beans.factory.config.BeanDefinition;

/**
 *Description:<br>
 *
 *@Author:lvkj@tsintergy.com
 *@Date: 2021/12/28 10:49 上午
 *@Version:1.0.0
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}