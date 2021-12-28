/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description: BeanFactory，代表了 Bean 对象的工厂，可以存放 Bean 定义到 Map 中以及获取。<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2021/12/17 4:09 下午
 * @Version:1.0.0
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}