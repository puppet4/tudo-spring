/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans.factory.support;

import com.tudo.springframework.beans.BeansException;
import com.tudo.springframework.beans.factory.BeanFactory;
import com.tudo.springframework.beans.factory.config.BeanDefinition;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2021/12/28 10:16 上午
 * @Version:1.0.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonRegistry implements BeanFactory {


    @Override
    public Object getBean(String name) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);
}