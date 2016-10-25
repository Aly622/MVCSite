package com.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Oliver.Liu on 2/29/2016.
 */
public class ReflectGeneric {
    /**
     * ��ò��������͵ķ������ͣ�ȡ��һ�������ķ������ͣ���Ĭ��ȥ�ĵ�һ����
     *
     * @param clazz ����������
     * @return ��������
     */
    @SuppressWarnings("unchecked")
    public static Class getClassGenricType(final Class clazz) {
        return getClassGenricType(clazz, 0);
    }

    /**
     * ���ݲ���������ò��������͵ķ������ͣ���ͨ������ȡ�ã�
     *
     * @param clazz ����������
     * @param index ��������
     * @return ��������
     */
    @SuppressWarnings("unchecked")
    public static Class getClassGenricType(
            final Class clazz, final int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }
}
