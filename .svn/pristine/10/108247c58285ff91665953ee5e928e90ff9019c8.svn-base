package com.shop.biz.order;

import com.github.pagehelper.util.StringUtil;
import com.shop.HttpResult;
import com.shop.biz.BaseController;
import com.shop.enums.ErrorCode;
import com.shop.enums.SignType;
import com.shop.util.pay.*;
import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("/pay")
public class PayController extends BaseController {


    private static final long serialVersionUID = 1L;



    @RequestMapping(value = "/payment")
    public HttpResult payment(HttpServletRequest request, String money, String openid, String body) {
        if (StringUtils.isEmpty(money)) {
            return HttpResult.build("参数错误：money不能为空！");
        }
        if (StringUtils.isEmpty(openid)) {
            return HttpResult.build("参数错误：openid不能为空！");
        }
        if (StringUtil.isEmpty(body)) {
            return HttpResult.build("参数错误：body不能为空！");
        }
        Map<String, String> data = new HashMap<String, String>();
        Map<String, Object> map = new HashMap<String, Object>();
        data.put("appid", Configure.getAppID());//公众账号ID
        data.put("mch_id", Configure.getMch_id());//商户号
        data.put("nonce_str", RandomStringGenerator.getRandomStringByLength(32));//随机字符串
        data.put("openid", openid);//用户标识
        data.put("body", body);//商品描述
        data.put("out_trade_no", RandomStringGenerator.getRandomStringByLength(18));//商户订单号
        data.put("fee_type", "CNY");//
        data.put("total_fee", money);//标价金额
        data.put("spbill_create_ip", request.getRemoteAddr());//终端IP
        data.put("notify_url", Configure.notify_url);//回调地址
        data.put("trade_type", Configure.trade_type);  //交易类型
        //生成签名
        String signXml = "";
        try {
            //调用demo里面的sign生成方法
            String sign =  PayUtil.sign(WechatPayUtil.buildParam(data), Configure.getKey(), SignType.MD5.getCode());
            data.put("sign",sign.toUpperCase());
            SortedMap<String,String> parameters=new TreeMap<String,String>(data);
            signXml =WechatPayUtil.mapToXml(parameters);
            String result = HttpRequestClient.sendPost(Configure.url, signXml);
            log.info(result);
            XStream xStream = new XStream();
            XStream.setupDefaultSecurity(xStream);
            //出于安全考虑，这里必须限制类型，不然会报错
            xStream.allowTypes(new Class[]{OrderReturnInfo.class});
            xStream.alias("xml", OrderReturnInfo.class);

            OrderReturnInfo returnInfo = (OrderReturnInfo) xStream.fromXML(result);
            // 二次签名
            if ("SUCCESS".equals(returnInfo.getReturn_code()) && returnInfo.getReturn_code().equals(returnInfo.getResult_code())) {
                long time = System.currentTimeMillis() / 1000;

                //生成签名（官方给出来的签名方法）
                Map<String, String> map2 = new HashMap<>();
                map2.put("appId", Configure.getAppID());
                map2.put("timeStamp", String.valueOf(time));
                //这边的随机字符串必须是第一次生成sign时，微信返回的随机字符串，不然小程序支付时会报签名错误
                map2.put("nonceStr", returnInfo.getNonce_str());
                map2.put("package", "prepay_id=" + returnInfo.getPrepay_id());
                map2.put("signType", "MD5");
                String sign2 = PayUtil.sign(WechatPayUtil.buildParam(map2), Configure.getKey(), SignType.MD5.getCode());
                log.info("二次签名的sign2----->" + sign2);
                //无效的签名方法
                //String sign1 = Signature.getSign(signInfo);
                Map<String, Object> payInfo = new HashMap<String, Object>();
                payInfo.put("timeStamp", String.valueOf(time));
                payInfo.put("nonceStr", returnInfo.getNonce_str());
                payInfo.put("prepay_id", returnInfo.getPrepay_id());
                payInfo.put("signType", "MD5");
                payInfo.put("paySign", sign2);
                map.put("status", 200);
                map.put("msg", "统一下单成功!");
                map.put("data", payInfo);
                // 此处可以写唤起支付前的业务逻辑

                // 业务逻辑结束
                return HttpResult.ok(map);
            }
            map.put("status", 500);
            map.put("msg", "统一下单失败!");
            map.put("data", returnInfo);
            return HttpResult.build(ErrorCode.USER_CONFIRM_FAIL, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HttpResult.build("Success!");
    }

    /**
     * 微信小程序支付成功回调函数
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/weixin/callback/wxNotify")
    public void wxNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String resXml = "";
        BufferedOutputStream out = null;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            //sb为微信返回的xml
            String notityXml = sb.toString();
            log.info("接收到的报文：" + notityXml);
            @SuppressWarnings("unchecked")
            Map<String, String> map = PayUtil.doXMLParse(notityXml);

            String returnCode = (String) map.get("return_code");
            if ("SUCCESS".equals(returnCode)) {
                //验证签名是否正确
                Map<String, String> validParams = PayUtil.paraFilter(map);  //回调验签时需要去除sign和空值参数
                String validStr = PayUtil.createLinkString(validParams);//把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
                String sign = PayUtil.sign(validStr, Configure.getKey(), "utf-8").toUpperCase();//拼装生成服务器端验证的签名
                // 因为微信回调会有八次之多,所以当第一次回调成功了,那么我们就不再执行逻辑了

                //根据微信官网的介绍，此处不仅对回调的参数进行验签，还需要对返回的金额与系统订单的金额进行比对等
                if (sign.equals(map.get("sign"))) {
                    /**此处添加自己的业务逻辑代码start**/
                    // bla bla bla....
                    /**此处添加自己的业务逻辑代码end**/
                    //通知微信服务器已经支付成功
                    resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                            + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
                } else {
                    log.info("微信支付回调失败!签名不一致");
                }
            } else {
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                        + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
            }
            log.info(resXml);
            log.info("微信支付回调数据结束");
            out = new BufferedOutputStream(response.getOutputStream());
            out.write(resXml.getBytes());
            out.flush();
            out.close();
        }catch (Exception e){
            out = new BufferedOutputStream(response.getOutputStream());
            out.write(resXml.getBytes());
            //支付失败
            String msg = e.getMessage();
            out.write(("支付回调失败:"+msg).getBytes("utf-8"));
            out.flush();
            out.close();
            log.error("wxNotify error msg: {}",e);
        }
    }

    private void successOrder(){

    }
}