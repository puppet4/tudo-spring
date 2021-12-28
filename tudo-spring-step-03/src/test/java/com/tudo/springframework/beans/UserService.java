/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2021/12/28 3:03 下午
 * @Version:1.0.0
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}