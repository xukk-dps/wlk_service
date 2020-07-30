package com.shop.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 对象转换
 * @author xkk
 */
public class ConvertUtils {

    /**
     * to vo
     * @param t
     * @param v
     * @param <T>
     * @param <V>
     */
    public static <T,V> void convert(T t,V v){
        BeanUtils.copyProperties(t,v);
    }

    /**
     * to vo list
     * @param lt
     * @param lv
     * @param <T>
     * @param <V>
     */
    public static <T,V> void convert(List<T> lt, List<V> lv){
        if(CollectionUtils.isEmpty(lt)){
            return;
        }
        for (int i = 0; i < lt.size(); i++) {
            convert(lt.get(i),lv.get(i));
        }
    }
}
