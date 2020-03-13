package com.weweibuy.webuy.common.utils;

import lombok.*;
import org.springframework.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author durenhao
 * @date 2020/3/13 21:05
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanCopyUtils {

    private static final Map<Key, BeanCopier> BEAN_COPIER_MAP = new ConcurrentHashMap<>(64);

    public static <T> T copy(Object src, Class<T> destClazz) {
        if (src == null || destClazz == null) {
            return null;
        }
        Class<?> srcClazz = src.getClass();
        Key key = new Key(srcClazz, destClazz);
        BeanCopier beanCopier = BEAN_COPIER_MAP.computeIfAbsent(key, k -> BEAN_COPIER_MAP.put(k, BeanCopier.create(srcClazz, destClazz, false)));
        T newInstance = null;
        try {
            newInstance = destClazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException(destClazz.getName() + " 必须含有公共空参构造");
        }
        beanCopier.copy(src, newInstance, null);
        return newInstance;
    }


    @AllArgsConstructor
    @EqualsAndHashCode
    static class Key implements Comparable<Key> {

        private Class srcClazz;

        private Class destClazz;

        @Override
        public int compareTo(Key other) {
            int result = this.srcClazz.toString().compareTo(other.srcClazz.toString());
            if (result == 0 && this.destClazz != null) {
                if (other.destClazz == null) {
                    return 1;
                }
                result = this.destClazz.toString().compareTo(other.destClazz.toString());
            }
            return result;
        }
    }

}
