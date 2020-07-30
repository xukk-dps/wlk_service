package com.shop.util.enc;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AESSecurityDecrypt {

    private static final String charsetName = "utf-8";

    /**
     * 指定加密算法为RSA
     */
    private static final String ALGORITHM = "AES";
    /**
     * 密钥串
     */
    public final static  String keyString = "4176bd3547364ead";



    /**
     * 生成密钥（需要更新密钥 用此方法生成）
     * @return str
     */
    public static String generateKeyString() {
        //必须长度为16
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
    }
    /**
     * 用来进行解密的操作
     *
     * @param encryptedData 密文
     * @throws Exception
     */
    public static String decrypt(String encryptedData) {
        try{
            Key key = generateKey(keyString);
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.DECRYPT_MODE, key);
            byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
            byte[] decValue = c.doFinal(decordedValue);
            //如果编码不为空则执行编码
            if(StringUtils.isNotBlank(charsetName)){
                 return new String(decValue,charsetName);
            }
            return  new String(decValue);
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
        Key key = new SecretKeySpec(keyString.getBytes(), ALGORITHM);
        return key;
    }

    /**
     * 处理密钥
     * @param key
     */
    private static void handleKey(String key){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) {
            list.add("\""+String.valueOf(key.charAt(i))+"\"");
        }
        System.out.println(list);
        String [] str = {"4", "1", "7", "6", "b", "d", "3", "5", "4", "7", "3", "6", "4", "e", "a", "d"};
        String str3 = StringUtils.join(str); // 数组转字符串,其实使用的也是遍历
        System.out.println(str3);
    }

    public static void main(String[] args) {
        System.out.println(decrypt("OKv2n3uOIXfnrF1CrUrXxxuhkkC1XIqxIMSy0lSALacUDHFAKE2MtwcVrFk/5X90Sq1xj6RCcrrXm0f0UHb+JYyIl/6WxfAx6Tk9mJeGijBBPVUG6ZWM7jWnlAzfaHcTjPXjIHtTJlv/NAVo10xE+vIh5UnjGBLQ4VJLKacGCQE="));
    }
}