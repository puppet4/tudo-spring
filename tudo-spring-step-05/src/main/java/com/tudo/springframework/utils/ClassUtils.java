/**
 * Copyright(C),2015‐2022,北京清能互联科技有限公司
 */
package com.tudo.springframework.utils;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2022/6/25 18:59
 * @Version:1.0.0
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {

        }
        if (cl == null) {
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}