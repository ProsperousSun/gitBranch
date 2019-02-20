package 线程池;

import java.util.Random;

public class ThreadLocalTest {

    public static class MyRunnable implements Runnable{



        private ThreadLocal<Integer> threadLocal=new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random()*1000));
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new MyRunnable(),"A");
        Thread t2=new Thread(new MyRunnable(),"B");
        t1.start();
        t2.start();

        System.out.println("---------------------");
    }
}
