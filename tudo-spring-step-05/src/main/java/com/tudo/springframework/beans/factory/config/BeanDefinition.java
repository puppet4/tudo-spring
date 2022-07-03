/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans.factory.config;

import com.tudo.springframework.beans.PropertyValues;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2021/12/28 2:17 下午
 * @Version:1.0.0
 */
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}