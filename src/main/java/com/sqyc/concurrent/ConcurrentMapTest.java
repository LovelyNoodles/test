package com.sqyc.concurrent;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class ConcurrentMapTest {
    public static void main(String[] args) {
        ConcurrentMap<Object, Object> map = new ConcurrentHashMap<>();
        map.put("", null);
    }


    @Test
    public void test1() throws InterruptedException {
        instanceLock();
        instanceLock();


        TimeUnit.SECONDS.sleep(60);
    }

    /**
     * 锁的是实例对象
     */
    private void instanceLock() {
        Hashtable<String, String> table = new Hashtable<String, String>() {
            @Override
            public synchronized String put(String key, String value) {
                System.out.println(Thread.currentThread().toString() + "input" + LocalDateTime.now() + "===============" + key + ":" + value);
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().toString() + "return" + LocalDateTime.now() + "===============" + key + ":" + value);
                return super.put(key, value);
            }

            @Override
            public synchronized String get(Object key) {
                System.out.println(Thread.currentThread().toString() + LocalDateTime.now() + "===============" + key);
                return super.get(key);
            }
        };
        table.put("abc", "abc");


        Runnable put = () -> table.put("abc", "abc1");
        Runnable get = () -> System.out.println(table.get("abc"));


        new Thread(put).start();
        new Thread(get).start();

        System.out.println("======================================");
    }
}
