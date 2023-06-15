package com.design;

import com.design.group.JDNetMall;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ApiTest {

    @Test
    public void test_NetMall() {
        NetMall netMall = new JDNetMall("1000001","*******");
        String base64 = netMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        log.info("测试结果：{}", base64);
    }


}
