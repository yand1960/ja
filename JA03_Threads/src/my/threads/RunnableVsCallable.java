package my.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableVsCallable {

    public static void main(String[] args) {
        try {

            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int i = -2; i < 3; i++) {
                        System.out.println(1 / i);
                    }
                }
            };

            ExecutorService executor = Executors.newFixedThreadPool(20);
            executor.execute(task);

            executor.shutdown();

        } catch (Exception ex) {
            System.out.printf("ERROR!");
        }
    }

    public static void main2(String[] args) {
        try {

             Callable<Integer> task = new Callable<Integer>() {
                @Override
                public Integer call() {
                    for (int i = -2; i < 3; i++) {
                        System.out.println(1 / i);
                    }
                    return 9999;
                }
            };

            ExecutorService executor = Executors.newFixedThreadPool(20);
            Future<Integer> result = executor.submit(task);

            //Здесь генерируется Exception
            result.get();

            executor.shutdown();

        }
        catch (Exception ex) {
            System.out.printf("ERROR!");
        }
    }

    public static void main1(String[] args) {
        try {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = -2; i < 3; i++) {
                        System.out.println(1 / i);
                    }
                }
            });
            t.setUncaughtExceptionHandler((e,o) -> {
                System.out.println("ERRRR");
            });
            t.start();
        }
        catch (Exception ex) {
            System.out.printf("ERROR!");
        }
    }
}
