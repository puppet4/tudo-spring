/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework;

/**
 * Description:BeanDefinition用于定义 Bean 实例化信息，现在的实现是以一个 Object 存放对象<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2021/12/17 4:08 下午
 * @Version:1.0.0
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}