/**
 * Copyright(C),2015‐2022,北京清能互联科技有限公司
 */
package com.tudo.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2022/6/25 18:58
 * @Version:1.0.0
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}