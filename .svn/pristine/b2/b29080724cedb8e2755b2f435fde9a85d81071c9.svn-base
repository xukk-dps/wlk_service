package com.shop.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName: ToolUtils
 * @description: 辅助工具类
 * @author: kangkang.xu
 * @date: Created in 17:29 2019/4/16
 * @Version: 1.0
 **/
public class ToolUtils {

    /**
     * 0
     */
    public static Long ZERO_LONG = 0L;
    /**
     * 空字符串
     */
    public static String EMPTY_STR = "";
    /**
     * 逗号
     */
    public static String COMMA = ",";
    /**
     * 百分号
     */
    private static String PERCENT_SIGN = "%";




    /**
     * 根据新id集合，和老id集合，获取去重后的集合
     * @param ids
     */
    public static List<Long> handleUpdateDataList(List<Long> ...ids){
        List<Long> retList = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            if(CollectionUtils.isEmpty(ids[i])){
                continue;
            }
            retList.addAll(ids[i]);
        }
        //去重并返回
        return new ArrayList<>( new HashSet<>(retList));
    }
    /**
     * 参数校验，如果有一个为空，则验证不通过 返回：false ，通过返回：true
     * @param param
     * @return boolean
     */
    public static boolean verifyStrParam(String ...param){
        for (int i = 0; i < param.length; i++) {
            if(StringUtils.isBlank(param[i])){
                return false;
            }
        }
        return true;
    }
    /**
     * 参数校验，如果有一个为空，则验证不通过 返回：false ，通过返回：true
     * @param param
     * @return boolean
     */
    public static boolean verifyByteParam(Byte ...param){
        for (int i = 0; i < param.length; i++) {
            if(null == param[i]){
                return false;
            }
        }
        return true;
    }
    /**
     * 半角转全角
     * @param input String.
     * @return 全角字符串.
     */
    public static String toSBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                c[i] = '\u3000';
            } else if (c[i] < '\177') {
                c[i] = (char) (c[i] + 65248);
            }
        }
        return new String(c);
    }

    /**
     * 全角转半角
     * @param input String.
     * @return 半角字符串
     */
    public static String toDBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '\u3000') {
                c[i] = ' ';
            } else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
                c[i] = (char) (c[i] - 65248);
            }
        }
        String returnString = new String(c);
        return returnString;
    }
    /**
     * list to strs 如：（a,b,c）
     * @param list
     * @return String
     */
    public static  String listToStrs(List  list) {
        if (!ToolUtils.verifyListParam(list)) {
            return  ToolUtils.EMPTY_STR;
        }
        return StringUtils.join(list, ToolUtils.COMMA);
    }
    /**
     * 字符串转list 正常字符串转list 如(a,b,c to [1,2,3])
     * @param str
     * @return list
     */
    public static List<Long> normalStrToLists(String str){
        String[] retArr = ToolUtils.splitStrArr(str);
        // 集合
        List<Long> conList = new ArrayList<>();
        if(null == retArr){
            return conList;
        }
        for (String s : retArr) {
            conList.add(ToolUtils.strTOLong(s));
        }
        return conList;
    }
    /**
     * list转字符串，并前后拼接逗号 如：（,a,b,c,）
     * @param list
     * @return String
     */
    public static String listToStrsAndComma(List list){
        if (!ToolUtils.verifyListParam(list)) {
            return  ToolUtils.EMPTY_STR;
        }
        return addComma(listToStrs(list));
    }
    /**
     * 字符串拼接，最后拼接上都好如：,a,b,c,
     * @param param
     * @return String
     */
    public static String splicingObj(Object ...param){
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STR);
        stringBuilder.append(COMMA);
        for (int i = 0; i < param.length; i++) {
            stringBuilder.append(objTOStr(param[i]));
            stringBuilder.append(COMMA);
        }
        return stringBuilder.toString();
    }
    /**
     * 如果有一个为null则校验不通过，返回:false ，校验通过返回:true
     * @param param
     * @return boolean
     */
    public static boolean verifyIntParam(Integer ...param){
        for (int i = 0; i < param.length; i++) {
            if(param[i] == null){
                return false;
            }
        }
        return true;
    }

    /**
     * 检验字符长度是否在特定范围内 true:在范围内 ，false：不再范围内
     * @param str
     * @param length
     * @return boolean
     */
    public static boolean checkStrLengthLimit(String str,int length) {
        if(StringUtils.isBlank(str)){
            return false;
        }
        if(str.length() > length){
            return false;
        }
        return true;
    }
    /**
     * 转为半角后的字符长度
     * @param str
     * @return int
     */
    public static int toDBCLenStr(String str) {
        if (str == null || str.length() == 0) {
            return NumberEntity.ZERO;
        }
        return toDBC(str).length();
    }
    /**
     * 获取全角字符长度
     * @param str
     * @return int
     */
    public static int getLenByteStr(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return str.getBytes().length;
    }
    /**
     * 如果有一个为null则校验不通过，返回:false ，校验通过返回:true
     * @param param
     * @return boolean
     */
    public static boolean verifyListParam(List param){
        if(CollectionUtils.isEmpty(param)){
            return false;
        }
        return true;
    }

    /**
     * 获取字符串长度
     * @param param
     * @return boolean
     */
    public static boolean checkStrLengthByLimit(String param,int length){
        if(StringUtils.isBlank(param)){
            return false;
        }
        if(param.length() > length){
            return true;
        }
        return false;
    }
    /**
     * 验证多个list为空
     * @param param
     * @return boolean
     */
    public static boolean verifyMoreListParam(List...param){
        for (int i = 0; i < param.length; i++) {
            if(CollectionUtils.isEmpty(param[i])){
                return false;
            }
        }
        return true;
    }
    /**
     *  Boolean 为空校验
     *  如果有一个为null则校验不通过，返回:false ，校验通过返回:true
     * @param param
     * @return boolean
     */
    public static boolean verifyBooleanParam(Boolean ...param){
        for (int i = 0; i < param.length; i++) {
            if(param[i] == null){
                return false;
            }
        }
        return true;
    }
    /**
     * 如果有一个为null则校验不通过，返回:false ，校验通过返回:true
     * @param param
     * @return boolean
     */
    public static boolean verifyLongParam(Long ...param){
        for (int i = 0; i < param.length; i++) {
            if(param[i] == null) {
                return false;
            }
        }
        return true;
    }
    /**
     * 如果有一个为null则校验不通过，返回:false ，校验通过返回:true
     * @param param
     * @return boolean
     */
    public static boolean verifyBigDecimalParam(BigDecimal...param){
        for (int i = 0; i < param.length; i++) {
            if(param[i] == null) {
                return false;
            }
        }
        return true;
    }
    /**
     * Long类型相加
     * @param param
     * @return Long
     */
    public static Long longPramSum(Long ...param){
        if( null == param ){
            return NumberEntity.lONG_ZERO;
        }
        Long allSum = NumberEntity.lONG_ZERO;
        for (int i = 0; i < param.length; i++) {
            if(param[i] == null){
                continue;
            }
            allSum+=param[i];
        }
        return allSum;
    }
    /**
     * 字符串开始跟结束添加逗号
     * @param str
     * @return String
     */
    public static String addComma(String str){
        if(StringUtils.isBlank(str)){
            return EMPTY_STR;
        }
        StringBuffer sb = new StringBuffer(EMPTY_STR);
        sb.append(COMMA);
        sb.append(str);
        sb.append(COMMA);
        return sb.toString();
    }

    /**
     * 添加逗号和百分号
     * @param str
     * @return String
     */
    public static String addCommaAndPercentSign(String str){
        if(!ToolUtils.verifyStrParam(str)){
            return null;
        }
        StringBuffer sb = new StringBuffer(EMPTY_STR);
        sb.append(PERCENT_SIGN);
        sb.append(addComma(str));
        sb.append(PERCENT_SIGN);
        return sb.toString();
    }

    /**
     * 前后拼接百分号 %a%
     * @param str
     * @return  String
     */
    public static String addPercentSign(String str){
        if(!ToolUtils.verifyStrParam(str)){
            return EMPTY_STR;
        }
        StringBuffer sb = new StringBuffer(EMPTY_STR);
        sb.append(PERCENT_SIGN);
        sb.append(str);
        sb.append(PERCENT_SIGN);
        return sb.toString();
    }

    /**
     * 如果Long为null则返回默认值0
     * @param num
     * @return long
     */
    public static long handleLongNullValue(Long num){
        if(null == num){
           return NumberEntity.lONG_ZERO;
        }
        return num ;
    }
    /**
     * 字符串分割为数组
     * @param str
     * @return String[]
     */
    public static String[] splitStrArr(String str){
        if(!ToolUtils.verifyStrParam(str)){
            return null;
        }
        return str.split(COMMA);
    }

    /**
     * 字符串转list ,a,b,c,  转a,b,c
     * @param str
     * @return List
     */
    public static List<Long> splitStrToList(String str){
        List<Long> list = new ArrayList<>();
        if(!ToolUtils.verifyStrParam(str)){
            return list;
        }
        String [] arrStr = splitStrArr(str);
        if(null == arrStr){return list;}
        for (int i = 1; i <arrStr.length ; i++) {
            list.add(strTOLong(arrStr[i]));
        }
        return list;
    }
    /**
     * 获取数组长度
     * @param str
     * @return int
     */
    public static int splitStrArr(String [] str){
        if(null == str){
            return NumberEntity.ZERO;
        }
        return str.length;
    }

    /**
     * 多个long数据相加
     * @param param
     * @return long
     */
    public static long addCalcLong(Long ...param){
        long result = NumberEntity.lONG_ZERO;
        if(null ==param){
            return NumberEntity.lONG_ZERO;
        }
        Long data ;
        for (int i = 0; i < param.length; i++) {
            data = param[i];
            if(null == data){
                data = NumberEntity.lONG_ZERO;
            }
            result+=data;
        }
        return result;
    }
    /**
     * 减法
     * @param a
     * @param b
     * @return int
     */
    public static int subtraction(int a,int b){
        return a - b;
    }

    /**
     * integer 相加
     * @param a
     * @param b
     * @return int
     */
    public static int integerAdd(Integer a,Integer b){
        if(null == a){ a = 0;}
        if(null == b){ b = 0;}
        return a + b;
    }
    /**
     * long 相减
     * @param a
     * @param b
     * @return Long
     */
    public static Long subtractionLong(Long a,Long b){
        if(null == a){
            a = NumberEntity.lONG_ZERO;
        }
        if(null == b){
            b = NumberEntity.lONG_ZERO;
        }
        return a - b;
    }
    /**
     * str to  Long
     * @param str
     * @return Long
     */
    public static Long strTOLong(String str){
        if(!ToolUtils.verifyStrParam(str)){
            return NumberEntity.lONG_ZERO;
        }
        try{
            return Long.parseLong(str);
        }catch (Exception e){
            return NumberEntity.lONG_ZERO;
        }
    }

    /**
     * 字符串转list （如：,1,2,3， to [1,2,3]）
     * @param ids
     * @return list
     */
    public static List<Long> strToList(String ids){
        String [] idsArr = ToolUtils.splitStrArr(ids);
        if(null == idsArr){
            return new ArrayList<>();
        }
        List<Long> idList = new ArrayList<>();
        //舍弃第一个对象，因为解析后第一个对象为逗号
        for (int i = 1; i < idsArr.length; i++) {
            idList.add(ToolUtils.strTOLong(idsArr[i]));
        }
        return idList;
    }
    /**
     *  str to int
     * @param str
     * @return Integer
     */
    public static Integer strTOInteger(String str){
        if(!ToolUtils.verifyStrParam(str)){
            return NumberEntity.ZERO;
        }
        try{
            return Integer.parseInt(str);
        }catch (Exception e){
            return NumberEntity.ZERO;
        }
    }
    /**
     * int to Long
     * @param param
     * @return Long
     */
    public static Long intToLong(int param){
        if(param == 0){
            return NumberEntity.lONG_ZERO;
        }
        return Long.valueOf(param);
    }
    /**
     * obj to str
     * @param str
     * @return
     */
    public static String objTOStr(Object str){
        if(null == str){
            return EMPTY_STR;
        }
        try{
            return str.toString();
        }catch (Exception e){
            return EMPTY_STR;
        }
    }

    /**
     * obj ro dou
     * @param obj
     * @return int
     */
    public static double objTODouble(Object obj){
        if(null == obj){
            return 0;
        }
        try{
            return Double.parseDouble(objTOStr(obj));
        }catch (Exception e){
            return 0;
        }
    }

    /**
     * Integer 获取int，防止计算时有nnp
     * @param integer
     * @return int
     */
    public static int getInt(Integer integer){
        if(null == integer){
            return 0;
        }
        return integer;
    }
    /**
     * obj ro int
     * @param obj
     * @return int
     */
    public static int objTOInt(Object obj){
        if(null == obj){
            return 0;
        }
        try{
            return Integer.parseInt(objTOStr(obj));
        }catch (Exception e){
            return 0;
        }
    }
    /**
     * obj ro long
     * @param obj
     * @return long
     */
    public static long objTOLong(Object obj){
        if(null == obj){
            return 0;
        }
        try{
            return Long.parseLong(objTOStr(obj));
        }catch (Exception e){
            return 0;
        }
    }
    /**
     * Long to str
     * @param param
     * @return String
     */
    public static String longTOStr(Long param){
        if(!ToolUtils.verifyLongParam(param)){
            return EMPTY_STR;
        }
        return String.valueOf(param);
    }

    /**
     * 处理Long数据，如果为null则返回0L,防止程序报错
     * @param param
     * @return
     */
    public static Long handleLong(Long param){
        if(null == param){
          return NumberEntity.lONG_ZERO;
        }
        return param;
    }
    /**
     * Integer to str
     * @param param
     * @return String
     */
    public static String integerTOStr(Integer param){
        if(!ToolUtils.verifyIntParam(param)){
            return EMPTY_STR;
        }
        return String.valueOf(param);
    }
    /**
     * 截取字符串，去掉第一个字符和最后一个字符
     * @param str
     * @return String
     */
    public static String subStrStartAndEnd(String str){
        if(!ToolUtils.verifyStrParam(str)) {
            return EMPTY_STR;
        }
        if(str.length()>1){
            return str.substring(1,str.length()-1);
        }
        return EMPTY_STR;
    }

    /**
     * 去掉最后一位字符
     * @param str
     * @return String
     */
    public static String subStrEnd(String str){
        if(!ToolUtils.verifyStrParam(str)) {
            return EMPTY_STR;
        }
        if(str.length()>1){
          return  str.substring(0,str.length()-1);
        }
        return EMPTY_STR;
    }
    /**
     * 拼拼接字符串
     * @param str
     * @return String
     */
    public static String splicingStr(String ...str){
        if(str.length == 0) {
            return EMPTY_STR;
        }
        StringBuilder sb = new StringBuilder(EMPTY_STR);
        for (int i = 0; i < str.length; i++) {
            if(!verifyStrParam(str[i])) {
                continue;
            }
            sb.append(str[i]);
            sb.append(COMMA);
        }
        String result = sb.toString();
        if(verifyStrParam(result)){
            return result.substring(0,result.length()-1);
        }
        return EMPTY_STR;
    }
}
