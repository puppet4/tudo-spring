/**
 * Copyright(C),2015‐2022,北京清能互联科技有限公司
 */
package com.tudo.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.tudo.springframework.beans.BeansException;
import com.tudo.springframework.beans.PropertyValue;
import com.tudo.springframework.beans.factory.config.BeanDefinition;
import com.tudo.springframework.beans.factory.config.BeanReference;
import com.tudo.springframework.core.io.Resource;
import com.tudo.springframework.core.io.ResourceLoader;
import java.io.IOException;
import java.io.InputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Description:<br>
 *
 * @Author:lvkj@tsintergy.com
 * @Date: 2022/6/25 20:08
 * @Version:1.0.0
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefintionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try (InputStream inputStream = resource.getInputStream()) {
            doLoadBeanDefinitions(inputStream);
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            //判断元素
            if (!(childNodes.item(i) instanceof Element)) {
                continue;
            }
            //判断对象
            if (!"bean".equals(childNodes.item(i).getNodeName())) {
                continue;
            }

            //解析标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            //获取Class，方便获取类中的名称
            Class<?> clazz = Class.forName(className);
            //优先级id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            //定义Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            //读取属性并填充
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(bean.getChildNodes().item(j) instanceof Element)) {
                    continue;
                }
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) {
                    continue;
                }
                //解析标签，property
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                //获取属性值，引入对象，值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrName) : attrValue;
                //创建属性信息
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            //注册BeanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }
}