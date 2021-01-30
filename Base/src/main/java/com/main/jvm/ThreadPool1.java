package com.main.jvm;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ThreadPool1 {
    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = null;
        //ThreadFactorythreadFactory threadFactorythreadFactory;
        RejectedExecutionHandler handler = null;
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(
                        1,10,1000,SECONDS,
                        workQueue,

                handler);

    }

}
