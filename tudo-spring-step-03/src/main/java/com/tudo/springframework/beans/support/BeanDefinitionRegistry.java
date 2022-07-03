package com.tudo.springframework.beans.support;

import com.tudo.springframework.beans.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}