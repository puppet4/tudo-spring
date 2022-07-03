/**
 * Copyright(C),2015‐2022,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2022/6/24 13:59
 * @Version:1.0.0
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    private PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}