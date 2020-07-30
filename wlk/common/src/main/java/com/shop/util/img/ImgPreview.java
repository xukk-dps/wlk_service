package com.shop.util.img;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 图片预览
 *
 * @author xkk
 * @date 2020/04/15
 */
public class ImgPreview {


    /**
     * 图片预览
     *
     * @param response
     * @param viewName
     */
    public static void preview(HttpServletResponse response, String path, String viewName) {
        if (null == response) {
            throw new RuntimeException("响应对象为空");
        }
        viewName = path + viewName;
        response.setContentType("text/html; charset=UTF-8");
        response.setContentType("image/jpeg");
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            fis = new FileInputStream(viewName);
            int count = 0;
            byte[] buffer = new byte[1024 * 1024];
            while ((count = fis.read(buffer)) != -1) {
                os.write(buffer, 0, count);
            }
            os.flush();
        } catch (IOException e) {
            try {
                os.write("error".getBytes("utf-8"));
                os.flush();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
