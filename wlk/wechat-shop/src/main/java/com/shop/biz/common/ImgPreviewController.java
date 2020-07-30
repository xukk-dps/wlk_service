package com.shop.biz.common;

import com.shop.util.img.ImgPreview;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("/img")
public class ImgPreviewController {

    @Value("${shop.path.img}")
    public String imgPath;


    /*
     * 预览图片
     */
    @RequestMapping("/preview")
    public void showImage(HttpServletResponse response, String name) {
        long st = System.currentTimeMillis();
        log.info("img preview ：{}", imgPath + name);
        ImgPreview.preview(response,imgPath, name);
        log.info("img preview  use time:{}",(System.currentTimeMillis() - st) + " ms");
    }
}
