/**
 * Copyright(C),2015‐2022,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans.factory.support;

import com.tudo.springframework.core.io.DefaultResourceLoader;
import com.tudo.springframework.core.io.ResourceLoader;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2022/6/25 18:56
 * @Version:1.0.0
 */
public abstract class AbstractBeanDefintionReader implements BeanDefinitionReader {

    public final BeanDefinitionRegistry registry;

    public ResourceLoader resourceLoader;

    public AbstractBeanDefintionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefintionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}