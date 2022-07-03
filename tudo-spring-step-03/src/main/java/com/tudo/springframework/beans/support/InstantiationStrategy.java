/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans.support;

import com.tudo.springframework.beans.BeansException;
import com.tudo.springframework.beans.config.BeanDefinition;
import java.lang.reflect.Constructor;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2021/12/28 2:21 下午
 * @Version:1.0.0
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args)
        throws BeansException;
}