package org.star5025.bigevent;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    @Test
    public void testThreadLocalSetAndGet() {
        //提供一个ThreadLocal对象
        ThreadLocal threadLocal = new ThreadLocal();
        //开启两个线程
        new Thread(()->{
            threadLocal.set("1star");
            System.out.println(Thread.currentThread().getName()+": "+threadLocal.get());
        }, "蓝色").start();
        new Thread(()->{
            threadLocal.set("onestar");
            System.out.println(Thread.currentThread().getName()+": "+threadLocal.get());
        }, "绿色").start();
    }
}
