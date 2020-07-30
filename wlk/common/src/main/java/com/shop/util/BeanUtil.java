package com.shop.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.shop.exception.ServiceException;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;



/**
 * @ClassName: BeanUtil
 * @description: 对象转换工具
 * @author: xkk
 * @date: Created in 9:18 2020/4/15
 * @Version: 1.0
 **/
public final class BeanUtil {

    private static final ConcurrentHashMap<String, BeanCopier> BEAN_COPIER_CACHE = new ConcurrentHashMap();

    private BeanUtil(){

    }

    /**
     * 复制属性：从源对象复制和目标对象相同的属性
     *
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copy(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }
        BeanCopier beanCopier = getBeanCopier(source.getClass(), target.getClass());
        beanCopier.copy(source, target, null);
    }

    /**
     * 复制源对象集合到目标对象列表
     *
     * @param source 源对象
     * @param destType 目标对象
     * @param <T> 源对象类型参数
     * @param <K> 目标对象类型参数
     * @return 结果集合,一个list
     */
    public static <T, K> List<K> copyAs(Collection<T> source, Class<K> destType) {
        if (CollectionUtils.isEmpty(source) || destType == null) {
            return Collections.EMPTY_LIST;
        }

        List<K> result = new ArrayList<K>();
        if (source.isEmpty()) {
            return result;
        }
        try {
            for (Object object : source) {
                BeanCopier beanCopier = getBeanCopier(object.getClass(), destType);
                K dest = destType.newInstance();
                beanCopier.copy(object, dest, null);
                result.add(dest);
            }
        } catch (Exception e) {
            throw new ServiceException(e);
        }
        return result;
    }

    private static BeanCopier getBeanCopier(Class<?> sourceClass, Class<?> destClass) {
        String key = sourceClass.getCanonicalName() + ":" + destClass.getCanonicalName();
        BeanCopier beanCopier = BEAN_COPIER_CACHE.get(key);
        if (beanCopier == null) {
            beanCopier = BeanCopier.create(sourceClass, destClass, false);
            BEAN_COPIER_CACHE.putIfAbsent(key, beanCopier);
        }
        return beanCopier;
    }

    /**
     * 去除首尾指定字符
     * @param str 字符串
     * @param element 指定字符
     * @return
     */
    public static String trimFirstAndLastChar(String str, String element){
        boolean beginIndexFlag = true;
        boolean endIndexFlag = true;
        do{
            int beginIndex = str.indexOf(element) == 0 ? 1 : 0;
            int endIndex = str.lastIndexOf(element) + 1 == str.length() ? str.lastIndexOf(element) : str.length();
            str = str.substring(beginIndex, endIndex);
            beginIndexFlag = (str.indexOf(element) == 0);
            endIndexFlag = (str.lastIndexOf(element) + 1 == str.length());
        } while (beginIndexFlag || endIndexFlag);
        return str;
    }
}
