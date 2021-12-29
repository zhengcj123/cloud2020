package com.dcsyun.springcloud.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengcj
 * @create 2021-06-11 11:22
 */
public class TestDemo {

    @Test
    public void stringTest2() {
        System.out.println("测试111111");
        System.out.println("测试22222222222222");
        String msg = "{\"ver\":3,\"cid\":\"ylgr/HUOQIUCHALU/2422\",\"datas\":[{\"ppn\":\"zongzhan_B1\",\"nm\":\"JSSSLL\",\"vt\":2,\"v\":\"0.01\"},{\"ppn\":\"zongzhan_B1\",\"nm\":\"CSSSLL\",\"vt\":2,\"v\":\"0.01\"},{\"ppn\":\"zongzhan_B1\",\"nm\":\"Tag336\",\"vt\":2,\"v\":\"2.73\"},{\"ppn\":\"zongzhan_B1\",\"nm\":\"Tag337\",\"vt\":2,\"v\":\"1.11\"},{\"ppn\":\"DB_B1\",\"nm\":\"A-BV\",\"vt\":2,\"v\":\"4099.00\"},{\"ppn\":\"DB_B1\",\"nm\":\"B-CV\",\"vt\":2,\"v\":\"4099.00\"},{\"ppn\":\"DB_B1\",\"nm\":\"A-CV\",\"vt\":2,\"v\":\"4094.00\"},{\"ppn\":\"DB_B1\",\"nm\":\"CA\",\"vt\":2,\"v\":\"26.00\"},{\"ppn\":\"DB_B1\",\"nm\":\"AV\",\"vt\":2,\"v\":\"2364.00\"},{\"ppn\":\"DB_B1\",\"nm\":\"BV\",\"vt\":2,\"v\":\"2370.00\"},{\"ppn\":\"DB_B1\",\"nm\":\"CV\",\"vt\":2,\"v\":\"2364.00\"},{\"ppn\":\"DB_B1\",\"nm\":\"ZGLYS\",\"vt\":2,\"v\":\"869.00\"},{\"ppn\":\"DB_B1\",\"nm\":\"ZYGGL\",\"vt\":2,\"v\":\"155.00\"},{\"ppn\":\"DB_B1\",\"nm\":\"ZSZGL\",\"vt\":2,\"v\":\"179.00\"},{\"ppn\":\"DB_B1\",\"nm\":\"DLBPHD\",\"vt\":2,\"v\":\"38.00\"}]}";
        Map<String, Object> map = new HashMap<>();
        List<Map> list = (List<Map>) map.get("datas");
        for (Map map2 : list) {
            Object object = map2.get("nm");
            System.out.println("测试git提交");
            System.out.println(object);
        }
    }

}
