/**
 * Copyright(C),2015‐2022,北京清能互联科技有限公司
 */
package com.tudo.springframework.core.io;

import cn.hutool.core.lang.Assert;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2022/6/25 18:57
 * @Version:1.0.0
 */
public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException ex) {
                return new FileSystemResource(location);
            }
        }
    }
}