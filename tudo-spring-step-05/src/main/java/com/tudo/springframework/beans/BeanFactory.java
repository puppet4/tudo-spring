/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2021/12/28 10:19 上午
 * @Version:1.0.0
 */
public interface BeanFactory {

    /**
     * 功能描述: 无参构造函数实例化<br>
     *
     * @return: java.lang.Object
     * @since: 1.0.0
     * @author: lvkj@tsintergy.com
     * @date: 2021/12/28 2:20 下午
     */
    Object getBean(String name);

    /**
     * 功能描述: 传递入参给构造函数实例化<br>
     *
     * @return: java.lang.Object
     * @since: 1.0.0
     * @author: lvkj@tsintergy.com
     * @date: 2021/12/28 2:20 下午
     */
    Object getBean(String name, Object... args) throws BeansException;
}