package com.tudo.springframework.beans.support;

import com.tudo.springframework.beans.config.SingletonBeanRegistry;
import java.util.HashMap;
import java.util.Map;

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