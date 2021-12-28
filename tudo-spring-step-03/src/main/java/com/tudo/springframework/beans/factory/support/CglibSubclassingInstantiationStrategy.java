/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans.factory.support;

import com.tudo.springframework.beans.BeansException;
import com.tudo.springframework.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * Description: Cglib实例化，采用策略模式<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2021/12/28 2:33 下午
 * @Version:1.0.0
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args)
        throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor) {
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}