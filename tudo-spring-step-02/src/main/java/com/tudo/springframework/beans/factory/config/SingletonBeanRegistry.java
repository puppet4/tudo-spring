/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans.factory.config;

/**
 * Description: 获取单例对象接口<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2021/12/28 10:11 上午
 * @Version:1.0.0
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}