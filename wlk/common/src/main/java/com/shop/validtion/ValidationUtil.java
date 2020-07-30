package com.shop.validtion;

import com.shop.annonation.FieldNotNull;
import com.shop.annonation.NotBlank;
import com.shop.enums.ErrorCode;
import com.shop.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xkk
 * @version v1.0
 **/
@Slf4j
public class ValidationUtil {

    public static <T> void validate(T t) {
        if (t == null) {
            return;
        }

        List<Field> fieldList = getRelativeFields(t.getClass());

        fieldList.forEach(field -> {
            checkNotBlank(field, t);
            checkNotNull(field, t);
        });
    }

    private static List<Field> getRelativeFields(Class<?> clazz) {
        List<Field> result = new ArrayList<>();
        while (clazz != null) {
            result.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return result;
    }

    private static <T> void checkNotNull(Field field, T t) {
        FieldNotNull annotation = field.getAnnotation(FieldNotNull.class);
        if (annotation == null) {
            return;
        }
        field.setAccessible(true);
        try {
            Object o = field.get(t);
            if (o == null) {
                log.info("NotNull check failed: " + t.getClass().toString() + "." + field.getName());
                throw new ServiceException(ErrorCode.ILLEGAL_PARAMETER, annotation.message());
            }

        } catch (IllegalAccessException e) {
            log.info("reflection validation access exception: " + t.getClass().toString() + "." + field.getName());
            throw new ServiceException(ErrorCode.ILLEGAL_PARAMETER, "field name = " + field.getName());
        }
    }

    private static <T> void checkNotBlank(Field field, T t) {
        NotBlank annotation = field.getAnnotation(NotBlank.class);
        if (annotation == null) {
            return;
        }
        field.setAccessible(true);
        try {
            Object o = field.get(t);
            if (o == null) {
                throw new ServiceException(ErrorCode.ILLEGAL_PARAMETER, annotation.message() + "为空");
            }
            if (o instanceof Enum) {
                return;
            }
            if (!(o instanceof String)) {
                return;
            }

            String val = (String) o;
            if (StringUtils.isBlank(val)) {
                log.info("NotBlank check failed: " + t.getClass().toString() + "." + field.getName());
                throw new ServiceException(ErrorCode.ILLEGAL_PARAMETER, annotation.message() + "为空");
            }

            if (annotation.maxLen() != 0 && val.length() > annotation.maxLen()) {
                log.info("NotBlank check failed: " + t.getClass().toString() + "." + field.getName()
                        + ":More than the maximum length");
                throw new ServiceException(ErrorCode.ILLEGAL_PARAMETER, annotation.message() + "长度 【" + annotation.minLen() + "-" + annotation.maxLen() + "】");

            }
            if (annotation.minLen() != 0 && val.length() < annotation.minLen()) {
                log.info("NotBlank check failed: " + t.getClass().toString() + "." + field.getName()
                        + ":More than the minimum length");
                throw new ServiceException(ErrorCode.ILLEGAL_PARAMETER, annotation.message() + "长度 【" + annotation.minLen() + "-" + annotation.maxLen() + "】");
            }
            //非法字符验证true为包含，false为不包含
            if(IllegalCharacter.isSpecialChar(val)){
                throw new ServiceException(ErrorCode.ILLEGAL_CHARACTER,annotation.message() + "含有非法字符");
            }
        } catch (IllegalAccessException e) {
            log.info("reflection validation access exception: " + t.getClass().toString() + "." + field.getName());
            throw new ServiceException(ErrorCode.ILLEGAL_PARAMETER, "field name = " + field.getName());
        }
    }

}
