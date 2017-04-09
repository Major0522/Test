package com.major.java.container.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {
	
	public static void main(String[] args) {
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
		
		Producer producer1 = new Producer(queue);
	    Producer producer2 = new Producer(queue);
	    Producer producer3 = new Producer(queue);
	    Consumer consumer = new Consumer(queue); 
	    
	 // 借助Executors
	    ExecutorService service = Executors.newCachedThreadPool();
	    // 启动线程
	    service.execute(producer1);
	    service.execute(producer2);
	    service.execute(producer3);
	    service.execute(consumer);

	    // 执行10s
	    try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    producer1.stop();
	    producer2.stop();
	    producer3.stop();

	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    // 退出Executor
	    service.shutdown();
	}
	 
}
