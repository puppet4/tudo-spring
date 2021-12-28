/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans.factory.support;

import com.tudo.springframework.beans.factory.config.SingletonBeanRegistry;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 在 DefaultSingletonBeanRegistry 中主要实现 getSingleton 方法，同时实现了一个 受保护的 addSingleton 方法，这个方法可以被继承此类的其他类调用。包括：
 * AbstractBeanFactory 以及继承的 DefaultListableBeanFactory 调用<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2021/12/28 10:13 上午
 * @Version:1.0.0
 */
public class DefaultSingletonRegistry implements SingletonBeanRegistry {

    private Map<String, Object> stringObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return stringObjects.get(beanName);
    }

    public void addSingleton(String beanName, Object singleObject) {
        stringObjects.put(beanName, singleObject);
    }
}