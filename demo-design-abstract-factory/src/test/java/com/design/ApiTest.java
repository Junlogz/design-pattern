package com.design;

import com.design.factory.impl.EGMCacheAdapter;
import com.design.factory.impl.IIRCacheAdapter;
import com.design.impl.CacheServiceImpl;
import com.design.service.CacheService;
import org.junit.jupiter.api.Test;

public class ApiTest {

    @Test
    public void test_CacheService() throws Exception {
        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01","张三");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println(val01);

        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01","李四");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println(val02);
    }


}
