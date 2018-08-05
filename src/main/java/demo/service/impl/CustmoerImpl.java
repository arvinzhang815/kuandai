package demo.service.impl;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.security.Principal;
import java.util.*;

/**
 * @author Created by: zhangbingbing
 * @date 2018/7/3
 **/
public class CustmoerImpl extends Thread{

    private static final int CAPACITY = 5;

    public static void main(String args[]){
        List<Object> queue = new LinkedList<Object>();

        Thread producer1 = new produce("P-1", queue, CAPACITY);
        Thread producer2 = new produce("P-2", queue, CAPACITY);
        Thread consumer1 = new custmoer("C1", queue, CAPACITY);
        Thread consumer2 = new custmoer("C2", queue, CAPACITY);
        Thread consumer3 = new custmoer("C3", queue, CAPACITY);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }


    public static class produce extends Thread{

        private int max_size = 10;
        private List<Object> queue;
        private String name;
        private int i ;

        public produce(String name,List<Object> queue, int max_size){
            super(name);
            this.max_size = max_size;
            this.queue = queue;
        }


        @Override
        public void run(){
            while (true) {
                synchronized (queue) {
                    if (queue.size() == max_size) {
                        System.out.println("队列已经满了，不需要生产了，请稍等！");
                        try {
                            queue.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("[" + name + "] Producing value : +" + i);
                    queue.add("hello" + ++i);
                    queue.notifyAll();

                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class custmoer extends Thread{

        private int max_size = 10;
        private List<Object> queue;
        private String name;
        private int i ;

        public custmoer(String name,List<Object> queue, int max_size){
            super(name);
            this.max_size = max_size;
            this.queue = queue;
        }


        @Override
        public void run(){
            while (true) {
                synchronized (queue) {
                    if (queue.size() == 0) {
                        System.out.println("队列已经空了，不能消费了，请稍等！");
                        try {
                            queue.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("[" + name + "] custmoer value : +" + i);
                    queue.remove(0);
                    queue.notifyAll();

                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
