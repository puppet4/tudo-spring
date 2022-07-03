/**
 * Copyright(C),2015‐2022,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans.factory.support;

import com.tudo.springframework.beans.BeansException;
import com.tudo.springframework.core.io.Resource;
import com.tudo.springframework.core.io.ResourceLoader;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2022/6/25 18:56
 * @Version:1.0.0
 */
public interface BeanDefinitionReader {


    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}