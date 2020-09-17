package com.creolophus.liuyi.common.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * @author magicnana
 * @date 2020/8/19 11:47 AM
 */
public class JacksonUtilTest extends JsonCoder {

    @Test
    public void toBean() {
        String json = JacksonUtil.toJson(bean);

        {
            ProductAppendClassVo ret = JacksonUtil.toJava(json, ProductAppendClassVo.class);
            Assert.assertEquals("类型不正确", ret.getClass(), ProductAppendClassVo.class);
            Assert.assertTrue("内部成员变量错误", ret.getProduct() != null);
            Assert.assertEquals("内部成员变量类型错误", ret.getProduct().getClass(), Product.class);
            Assert.assertEquals("内部 List 数量错误", ret.getPlatformList().size(), 4);
            Assert.assertEquals("内部 List 中的类型错误", ret.getPlatformList().get(0).getClass(), ProductAppendClassPlatformItemVo.class);
            Assert.assertEquals("泛型应该是 LinkedHashMap 类型", ret.getBody().getClass(), LinkedHashMap.class);
            Product obj = JacksonUtil.toJava(ret.getBody(), Product.class);
            Assert.assertTrue("泛型转换为 Product 错误", obj != null);
        }

        {
            ProductAppendClassVo ret = JacksonUtil.toJava(json, new TypeReference<ProductAppendClassVo<Product>>() {});
            Assert.assertEquals("类型不正确", ret.getClass(), ProductAppendClassVo.class);
            Assert.assertTrue("内部成员变量错误", ret.getProduct() != null);
            Assert.assertEquals("内部成员变量类型错误", ret.getProduct().getClass(), Product.class);
            Assert.assertEquals("内部 List 数量错误", ret.getPlatformList().size(), 4);
            Assert.assertEquals("内部 List 中的类型错误", ret.getPlatformList().get(0).getClass(), ProductAppendClassPlatformItemVo.class);
            Assert.assertEquals("通过 TypeReference 指定泛型类型错误", ret.getBody().getClass(), Product.class);
        }

        {
            JavaType javaType = JacksonUtil.mapper().getTypeFactory().constructParametricType(ProductAppendClassVo.class, Product.class);
            ProductAppendClassVo ret = JacksonUtil.toJava(json, javaType);
            Assert.assertEquals("类型不正确", ret.getClass(), ProductAppendClassVo.class);
            Assert.assertTrue("内部成员变量错误", ret.getProduct() != null);
            Assert.assertEquals("内部成员变量类型错误", ret.getProduct().getClass(), Product.class);
            Assert.assertEquals("内部 List 数量错误", ret.getPlatformList().size(), 4);
            Assert.assertEquals("内部 List 中的类型错误", ret.getPlatformList().get(0).getClass(), ProductAppendClassPlatformItemVo.class);
            Assert.assertEquals("通过 TypeReference 指定泛型类型错误", ret.getBody().getClass(), Product.class);
        }

    }

    @Test
    public void toJson() {
        String str = JacksonUtil.toJson(bean);
        Assert.assertTrue("返回结果为空", !(str == null || str.length() == 0));
        Assert.assertTrue("Long|long 类型不应该返回 String", str.contains("\"id\":100"));
        Assert.assertTrue("Null的属性不应该被序列化", !str.contains("cover"));
        Any any = JsonIterator.deserialize(str);
        Assert.assertEquals("复杂对象的成员变量序列化出错", any.get("platformList", 0, "clientList", 0, "clazzList", 0, "clazzName").toString(), "clazz 0.0.0");
        Assert.assertEquals("复杂对象的成员变量序列化出错", any.get("platformList", 3, "clientList", 3, "clazzList", 3, "clazzName").toString(), "clazz 3.3.3");
    }
}