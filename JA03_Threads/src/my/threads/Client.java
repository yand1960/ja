package my.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) throws InterruptedException {

//        Асинхронный код написать не проблема,
//        но рещение последующих проблем синхронизации
//        (в данном случае, проблема вывода покзааний
//        в правильном порядке) может оказазаться непростой

        SlowMeter meter = new SlowMeter();
        int[] n = {1,2,3,4,5,6,7,8,9};
        List<Integer> results = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();

        Arrays.stream(n).forEach(i -> {
            Thread thread = new Thread(() -> {
                int result = meter.measure(i);
                //System.out.println(result);
//                В это место потокоопасный код
                lock.lock();
                results.add(result);
                lock.unlock();
            });
            thread.start();
        });

//        Дешево и сердито
        Thread.sleep(3500);

        //Задача: отсортируйте результаты по убыванию,
        //современные методы
        System.out.println(results);

    }

    public static void main2(String[] args) {

//        Асинхронный код написать не проблема,
//        но рещение последующих проблем синхронизации
//        (в данном случае, проблема вывода покзааний
//        в правильном порядке) может оказазаться непростой

        SlowMeter meter = new SlowMeter();
        int[] n = {1,2,3,4,5,6,7,8,9};
        Arrays.stream(n).forEach(i -> {
            Thread thread = new Thread(() -> {
                int result = meter.measure(i);
                System.out.println(result);
            });
            thread.start();
        });
    }

    public static void main1(String[] args) {

//        Синхронный код становится неудовлетворительным
//        при наличии задержек в методе meter()

        SlowMeter meter = new SlowMeter();
//        for(int n=1; n < 10; n++) {
//            int result = meter.measure(n);
//            System.out.println(result);
//        }
        int[] n = {1,2,3,5,6,7,8,9};
        Arrays.stream(n).forEach(i -> {
            int result = meter.measure(i);
            System.out.println(result);
        });
    }
}
