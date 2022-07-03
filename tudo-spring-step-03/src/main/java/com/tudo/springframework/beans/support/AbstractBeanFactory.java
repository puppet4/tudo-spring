/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans.support;

import com.tudo.springframework.beans.BeansException;
import com.tudo.springframework.beans.config.BeanDefinition;
import com.tudo.springframework.beans.BeanFactory;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2021/12/28 2:18 下午
 * @Version:1.0.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonRegistry implements BeanFactory {


    @Override
    public Object getBean(String name) {
        return this.doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return this.doGetBean(name, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);
}