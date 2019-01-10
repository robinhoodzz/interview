package thread;

import java.util.concurrent.*;

/**
 * Created by robin on 19/1/9.
 */
public class CallableDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("线程执行");
        Thread.sleep(1000);
        return "SUCCESS";
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        CallableDemo demo = new CallableDemo();
        Future<String> future = service.submit(demo);

        System.out.println(future.get());


        service.shutdown();

    }
}
