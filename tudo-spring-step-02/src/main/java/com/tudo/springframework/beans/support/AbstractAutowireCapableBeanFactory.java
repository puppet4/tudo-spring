/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans.support;

import com.tudo.springframework.beans.BeansException;
import com.tudo.springframework.beans.config.BeanDefinition;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2021/12/28 10:26 上午
 * @Version:1.0.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }
}