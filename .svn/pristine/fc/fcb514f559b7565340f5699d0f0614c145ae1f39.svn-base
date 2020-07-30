package com.shop.biz.product;

import com.shop.HttpResult;
import com.shop.dto.PageResult;
import com.shop.dto.product.ShopProductRequest;
import com.shop.dto.user.ShopUserRequest;
import com.shop.entity.ShopProduct;
import com.shop.enums.ErrorCode;
import com.shop.enums.ExceptionCode;
import com.shop.exception.ServiceException;
import com.shop.product.ProductService;
import com.shop.validtion.ValidationUtil;
import com.shop.vo.product.ProductTypeVO;
import com.shop.vo.product.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/list")
    public HttpResult<List<ShopProduct>> list(@RequestBody ShopUserRequest shopUserRequest) {
        long st = System.currentTimeMillis();
        HttpResult<List<ShopProduct>> result;
        try {
            log.info("list request ,{}", shopUserRequest);
            ValidationUtil.validate(shopUserRequest);
            result = HttpResult.ok(productService.list(shopUserRequest.getAccount()));
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("list occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("list occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("list.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }

    /**
     * 类型导航
     */
    @GetMapping("/nav")
    public HttpResult<List<ProductTypeVO>> nav() {
        long st = System.currentTimeMillis();
        HttpResult<List<ProductTypeVO>> result;
        try {
            log.info("nav request ");
            result = HttpResult.ok(productService.navList());
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("nav occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("nav occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("nav.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }
    /**
     * 分页查询-产品列表
     *
     * @param query 查询条件
     * @return pageResult
     */
    @PostMapping("/pages")
    public HttpResult<PageResult<ProductVO>> pages(@RequestBody ShopProductRequest query) {
        long st = System.currentTimeMillis();
        log.info("pages product.query:{}", query);
        HttpResult<PageResult<ProductVO>> result;
        try {
            result = HttpResult.ok(productService.queryPage(query));
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = errorCode.getDesc() + ":" + e.getMessage();
            log.error("pages product occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
            result = HttpResult.build(errorCode, e.getMessage());
        } catch (Exception e) {
            log.error("pages product occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("pages product .resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }

    /**
     * 产品详情
     *
     * @param id 查询条件
     * @return pageResult
     */
    @GetMapping("/info/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpResult<ProductVO> info(@PathVariable("id") Long id) {
        long st = System.currentTimeMillis();
        log.info("info product.id:{}", id);
        HttpResult<ProductVO> result;
        try {
            result = HttpResult.ok(productService.info(id));
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = errorCode.getDesc() + ":" + e.getMessage();
            log.error("info product occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
            result = HttpResult.build(errorCode, e.getMessage());
        } catch (Exception e) {
            log.error("info product occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("info product .resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }
}
