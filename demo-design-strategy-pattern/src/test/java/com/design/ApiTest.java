package com.design;

import com.design.event.MJCouponDiscount;
import com.design.event.NYGCouponDiscount;
import com.design.event.ZJCouponDiscount;
import com.design.event.ZKCouponDiscount;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ApiTest {

    @Test
    public void test_zj() {
        // 直减；100-10，商品100元
        Context<Double> context = new Context<Double>(new ZJCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(10D, new BigDecimal(100));
        log.info("测试结果：直减优惠后金额 {}", discountAmount);
    }

    @Test
    public void test_mj() {
        // 满100减10，商品100元
        Context<Map<String,String>> context = new Context<Map<String,String>>(new MJCouponDiscount());
        Map<String,String> mapReq = new HashMap<String, String>();
        mapReq.put("x","100");
        mapReq.put("n","10");
        BigDecimal discountAmount = context.discountAmount(mapReq, new BigDecimal(100));
        log.info("测试结果：满减优惠后金额 {}", discountAmount);
    }

    @Test
    public void test_zk() {
        // 折扣9折，商品100元
        Context<Double> context = new Context<Double>(new ZKCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(0.9D, new BigDecimal(100));
        log.info("测试结果：折扣9折后金额 {}", discountAmount);
    }

    @Test
    public void test_nyg() {
        // n元购；100-10，商品100元
        Context<Double> context = new Context<Double>(new NYGCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(90D, new BigDecimal(100));
        log.info("测试结果：n元购优惠后金额 {}", discountAmount);

    }
}
