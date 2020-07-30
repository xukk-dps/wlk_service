package com.shop.util.enc;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * aes对称加密
 */
public class AESSecurityEncrypt {

    private static final String charsetName = "utf-8";

    private final static String [] str = {"4", "1", "7", "6", "b", "d", "3", "5", "4", "7", "3", "6", "4", "e", "a", "d"};
    /**
     * 加密算法
     * 指定加密算法为RSA
     */
    private static final String ALGORITHM = "AES";
    /**
     * 用来进行加密的操作
     *
     * @param data 需要加密的字符串
     * @return str
     */
    public static String encrypt(String data){
        try{
            Key key = generateKey(StringUtils.join(str));
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal;
            //如果编码格式不为空，则执行编码
            if(StringUtils.isNotBlank(charsetName)){
                encVal = c.doFinal(data.getBytes(charsetName));
            }else {
                encVal = c.doFinal(data.getBytes());
            }
            return new BASE64Encoder().encode(encVal).replaceAll("\r","").replaceAll("\n","").replaceAll("\t","");
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }


    /**
     * 根据密钥和算法生成Key
     *
     * @return
     * @throws Exception
     */
    private static Key generateKey(String keyString) throws Exception {
        return new SecretKeySpec(keyString.getBytes(), ALGORITHM);
    }

    public static void main(String[] args) {

        String source = "恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财恭喜发财!";// 要加密的字符串
        System.out.println("准备用密钥加密的字符串为：" + source);
        long st = System.currentTimeMillis();
        String cryptograph = encrypt(source);// 生成的密文
        System.out.println("用密钥加密后的结果为:" + cryptograph);
        System.out.println(" time 1: " + (System.currentTimeMillis() - st) + " ms");
        st = System.currentTimeMillis();
        encrypt(source);// 生成的密文
        System.out.println(" time 2: " + (System.currentTimeMillis() - st) + " ms");

    }


}