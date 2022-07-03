/**
 * Copyright(C),2015‐2022,北京清能互联科技有限公司
 */
package com.tudo.springframework.test.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2022/6/24 13:55
 * @Version:1.0.0
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("1001", "小明");
        hashMap.put("1002", "小王");
        hashMap.put("1003", "小李");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}