package com.creolophus.liuyi.common.json;


import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author magicnana
 * @date 2020/8/19 10:20 AM
 */
public class GsonUtilTest extends JsonCoder {

    @Test
    public void comprehensive() {
        {
            String json = "{\"name\":\"外部\",\"data\":[{\"name\":\"内部 1\"},{\"name\":\"内部 2\"}]}";

            GsonUtilTestComprehensive bean1 = new GsonUtilTestComprehensive();
            bean1.setName("内部 1");

            GsonUtilTestComprehensive bean2 = new GsonUtilTestComprehensive();
            bean2.setName("内部 2");

            List<GsonUtilTestComprehensive> list = Arrays.asList(bean1, bean2);

            GsonUtilTestComprehensive input = new GsonUtilTestComprehensive();
            input.setName("外部");
            input.setData(list);

            String json1 = GsonUtil.toJson(input);
            System.out.println(json1);
            Assert.assertTrue(json.equals(json1));
        }

        {

            GsonUtilTestComprehensive bean1 = new GsonUtilTestComprehensive();
            bean1.setName("内部 1");

            GsonUtilTestComprehensive bean2 = new GsonUtilTestComprehensive();
            bean2.setName("内部 2");

            bean1.setData(bean2);
            String json = GsonUtil.toJson(bean1);

            System.out.println(json);

            GsonUtilTestComprehensive bean3 = GsonUtil.toJava(json, GsonUtilTestComprehensive.class);
            GsonUtilTestComprehensive bean4 = GsonUtil.toJava(bean3.getData(), GsonUtilTestComprehensive.class);
            bean3.setData(bean4);

        }


        {

            GsonUtilTestComprehensive bean1 = new GsonUtilTestComprehensive();
            bean1.setName("内部 1");
            GsonUtilTestComprehensive bean2 = new GsonUtilTestComprehensive();
            bean2.setName("内部 2");
            GsonUtilTestComprehensive bean = new GsonUtilTestComprehensive();
            bean.setName("外部");
            bean.setData(Arrays.asList(bean1, bean2));
            String json = GsonUtil.toJson(bean);
            System.out.println(json);


            GsonUtilTestComprehensive ret = GsonUtil.toJava(json, GsonUtilTestComprehensive.class);
            ret.setData(GsonUtil.toJava(ret.getData(), ArrayList.class));
            System.out.println("OK");

            GsonUtilTestComprehensive ret2 = GsonUtil.toJava(json, GsonUtilTestComprehensive.class);
            ret2.setData(GsonUtil.toJava(ret2.getData(), new ParameterizedType() {
                @Override
                public Type[] getActualTypeArguments() {
                    return new Type[]{GsonUtilTestComprehensive.class};
                }

                @Override
                public Type getRawType() {
                    return ArrayList.class;
                }

                @Override
                public Type getOwnerType() {
                    return null;
                }
            }));
            System.out.println("OK");

        }
    }

    @Test
    public void excludePassword() {
        User user = new User();
        user.setName("haha");
        user.setPassword("123");
        System.out.println(user);
        System.out.println(GsonUtil.toJson(user));
        System.out.println(JacksonUtil.toJson(user));

        Assert.assertFalse("怎么没有排除呢?", GsonUtil.toJson(user).contains("password"));
        Assert.assertTrue("没想排除啊?", JacksonUtil.toJson(user).contains("password"));
    }

    @Test
    public void toBean() {
        String json = GsonUtil.toJson(bean);
        {
            ProductAppendClassVo ret = GsonUtil.toJava(json, ProductAppendClassVo.class);
            Assert.assertEquals("类型不正确", ret.getClass(), ProductAppendClassVo.class);
            Assert.assertTrue("内部成员变量错误", ret.getProduct() != null);
            Assert.assertEquals("内部成员变量类型错误", ret.getProduct().getClass(), Product.class);
            Assert.assertEquals("内部 List 数量错误", ret.getPlatformList().size(), 4);
            Assert.assertEquals("内部 List 中的类型错误", ret.getPlatformList().get(0).getClass(), ProductAppendClassPlatformItemVo.class);
            Assert.assertEquals("Object属性应该转为 LinkedTreeMap", ret.getBody().getClass(), LinkedTreeMap.class);

            Product product = GsonUtil.toJava(ret.getBody(), Product.class);
            Assert.assertTrue("LinkedTreeMap解析错误", product != null);

        }

        {
            Type type = new TypeToken<ProductAppendClassVo<Product>>() {}.getType();
            ProductAppendClassVo ret = GsonUtil.toJava(json, type);
            Assert.assertEquals("类型不正确", ret.getClass(), ProductAppendClassVo.class);
            Assert.assertTrue("内部成员变量错误", ret.getProduct() != null);
            Assert.assertEquals("内部成员变量类型错误", ret.getProduct().getClass(), Product.class);
            Assert.assertEquals("内部 List 数量错误", ret.getPlatformList().size(), 4);
            Assert.assertEquals("内部 List 中的类型错误", ret.getPlatformList().get(0).getClass(), ProductAppendClassPlatformItemVo.class);
            Assert.assertEquals("Object属性应该转为 Product", ret.getBody().getClass(), Product.class);
        }


    }

    @Test
    public void toJson() {
        String str = GsonUtil.toJson(bean);
        Assert.assertTrue("返回结果为空", !(str == null || str.length() == 0));
        Assert.assertTrue("Long|long 类型不应该返回 String", str.contains("\"id\":100"));
        Assert.assertTrue("Null的属性不应该被序列化", !str.contains("cover"));
        Any any = JsonIterator.deserialize(str);
        Assert.assertEquals("复杂对象的成员变量序列化出错", any.get("platformList", 0, "clientList", 0, "clazzList", 0, "clazzName").toString(), "clazz 0.0.0");
        Assert.assertEquals("复杂对象的成员变量序列化出错", any.get("platformList", 3, "clientList", 3, "clazzList", 3, "clazzName").toString(), "clazz 3.3.3");
    }

}