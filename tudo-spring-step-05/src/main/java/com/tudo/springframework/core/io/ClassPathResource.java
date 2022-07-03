/**
 * Copyright(C),2015‐2022,北京清能互联科技有限公司
 */
package com.tudo.springframework.core.io;


import cn.hutool.core.lang.Assert;
import com.tudo.springframework.utils.ClassUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2022/6/25 18:57
 * @Version:1.0.0
 */
public class ClassPathResource implements Resource {

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is;
        is = classLoader.getResourceAsStream(this.path);
        if (is == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return is;
    }
}