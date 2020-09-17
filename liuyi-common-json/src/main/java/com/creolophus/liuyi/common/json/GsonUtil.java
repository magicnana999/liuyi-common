package com.creolophus.liuyi.common.json;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * 默认忽略 Null 属性
 * 已制定 SimpleDateFormat
 * Object 或者泛型属性 有可能是 LinkedTreeMap
 * Object 或者泛型属性,如果制定 TypeToken,那么结果是目标类型 new TypeToken<ProductAppendClassVo<Product>>(){}.getType()
 * TypeToken没有实现Type 接口,所以 new TypeToken 之后,要 getType()
 * 这里还有一个把 LinkedTreeMap 转为 JavaObject 的方法
 * @author magicnana
 * @date 2020/8/18 6:26 PM
 */
public class GsonUtil {


    private static Gson gson = (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss").setExclusionStrategies(new ExclusionStrategy() {
        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            return f.getName().equals("password");
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
    }).create();

    public static Gson gson() {
        return gson;
    }

    public static synchronized void init(Gson input) {
        gson = input;
    }

    public static byte[] toByteArray(Object obj) {
        if(obj == null) {
            return null;
        }
        return gson.toJson(obj).getBytes();
    }

    /**
     * 如果泛型或 Object 是不确定的类型,需要在运行时根据不同的业务,解析成不同的类型,那么这里需要一个单独解析 LinkedTreeMap 的方法.
     * @param linkedTreeMap
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T toJava(Object linkedTreeMap, Type type) {
        if(linkedTreeMap == null) {
            return null;
        }
        JsonObject jsonObject = gson.toJsonTree(linkedTreeMap).getAsJsonObject();
        return toJava(jsonObject.toString(), type);

    }

    public static <T> T toJava(byte[] bytes, Type type) {
        if(bytes == null) {
            return null;
        }
        return gson.fromJson(new String(bytes), type);
    }

    /**
     * type 可以是 ProductAppendClassVo.class,如果 ProductAppendClassVo 中有 Object 或者泛型,那么它将是 LinkedTreeMap 类型.
     * type,可以是 new TypeToken<ProductAppendClassVo<Product>>(){}.getType();如果ProductAppendClassVo中有 Object 或者泛型,那么它将是 Product 类型.
     * @param string
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T toJava(String string, Type type) {
        if(null == string || "".equals(string)) {
            return null;
        }
        return gson.fromJson(string, type);
    }

    public static String toJson(Object obj) {
        if(obj == null) {
            return null;
        }
        return gson.toJson(obj);
    }
}
