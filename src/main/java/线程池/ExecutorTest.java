package 线程池;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.*;

public class ExecutorTest {
    public static void main(String[] args) {

    }
    @Test
    public void newCachedThreadPoolTest(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<10;i++){
            final int index=1;
            try {
                Thread.sleep((index)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index+"-->"+new Date().getTime()+"-->"+Thread.currentThread().getName());
                }
            });
        }
    }

    /**
     * 顶一个一个固定的线程池
     */
    @Test
    public void newFixedThreadPoolTest(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i=0;i<10;i++){
            final int index=1;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index+"-->"+new Date().getTime()+"-->"+Thread.currentThread().getName());
                        Thread.sleep(2000);
                    }catch (Exception e){

                    }
                }
            });
        }
    }

    /**
     * 感觉可以用来做一个单一的定时任务啊
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void scheduledExecutorServiceTest() throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        for (int i=0;i<10;i++) {
            System.out.println(scheduledExecutorService.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return 1;
                }
            }, 3, TimeUnit.SECONDS).get());
        }
       // scheduledExecutorServiceTest();//定时执行
    }
}
