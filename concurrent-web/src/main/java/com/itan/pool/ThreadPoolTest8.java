package com.itan.pool;

import java.util.concurrent.*;

/**
 * @Author: ye.yanbin
 * @Date: 2022/7/1
 * 有界队列测试
 */
public class ThreadPoolTest8 {
    public static void main(String[] args) {
        //maximumPoolSize设置为2，拒绝策略为AbortPolicy，直接抛出异常
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 2, 100L, TimeUnit.SECONDS,
                            new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i = 0; i < 6; i++) {
                final int no = i;
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " 处理任务 " + no);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}