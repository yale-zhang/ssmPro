package com.yale.ssm.util;

import java.util.List;

/**
 * 序列化工具
 */
public class ProtoStuffSerializerUtil {
    /**
     * 序列化对象
     * @param obj
     * @return
     */
    public static <T> byte[] serialize(T obj) {
        return null;
    }

    /**
     * 反序列化对象
     * @param paramArrayOfByte
     * @param targetClass
     * @return
     */
    public static <T> T deserialize(byte[] paramArrayOfByte, Class<T> targetClass) {
        return null;
    }

    /**
     * 序列化列表
     * @param objList
     * @return
     */
    public static <T> byte[] serializeList(List<T> objList) {
        return null;
    }

    /**
     * 反序列化列表
     * @param paramArrayOfByte
     * @param targetClass
     * @return
     */
    public static <T> List<T> deserializeList(byte[] paramArrayOfByte, Class<T> targetClass) {
        return null;
    }

}
