/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans.config;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2021/12/28 2:17 下午
 * @Version:1.0.0
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}