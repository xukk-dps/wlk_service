package com.shop.util.pay;

public class Configure {

        // 商户支付秘钥
        private static String key = "sdnasbdkjs41323SDKJLDSXUasconvfe";
        //小程序ID
        private static String appID = "wx9dae32e56248de40";
        //商户号
        private static String mch_id = "1598976511";
        // 小程序的secret
        private static String secret = "df2c8acce0275ffaebcb612e39329df7";

        //支付回调地址（你自己的请求地址，可以自己随意配置啦，写在这方便你理解）
        public static String notify_url = "https://runvp.com/shop/pay/weixin/callback/wxNotify";
        //交易类型（这里是小程序）
        public final static String trade_type = "JSAPI";
        //统一下单API接口链接（微信官方的接口）
        public final static String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";

        public static String getKey() {
            return key;
        }
        public static void setKey(String key) {
            Configure.key = key;
        }
        public static String getAppID() {
            return appID;
        }
        public static void setAppID(String appID) {
            Configure.appID = appID;
        }
        public static String getMch_id() {
            return mch_id;
        }
        public static void setMch_id(String mch_id) {
            Configure.mch_id = mch_id;
        }
        public static String getSecret() {
            return secret;
        }
        public static void setSecret(String secret) {
            Configure.secret = secret;
        }


}
