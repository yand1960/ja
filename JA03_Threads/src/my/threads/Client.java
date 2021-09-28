package my.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Использование Executors и Futures
//        (главное - в классе SlowMeter)

        SlowMeter meter = new SlowMeter();
        List<Future<Integer>> results = new ArrayList<>();

//        Асинхронные запуски при таком подходе весьма изящны
        for(int n = 1; n < 10; n++) {
            results.add(meter.measureAsync(n));
        }

        for(Future<Integer> f: results) {
            // вызов get() ждет получения результатов
            // и возвращает их сразу, если они уже готовы
            System.out.println(f.get());
        }

        //Executor'ы не заканчивают работу автоматом,
        // когда заканивает работу приложение,
        // поэтому их нужно останавливать явно
        meter.shutdown();
    }

    public static void main4(String[] args) throws InterruptedException {

//      Нюансы и варианты

        SlowMeter meter = new SlowMeter();
        ConcurrentHashMap<Integer,Integer> results
                                = new ConcurrentHashMap();
        // Иметь в пуле ссылки на все порожденные потоки
        // - это обычная практика
        List<Thread> pool = new ArrayList<>();

        for(int n = 1; n < 10; n++) {
            final int m = n;
            Thread thread = new Thread(() -> {
                int result = meter.measure(m);
//              Используем потобезопасную коллекцию
                results.put(m, result);
            });
            pool.add(thread);
            thread.start();
        }

        //Универсальный способ
        // определить окончание работы всех потоков
        for(Thread t: pool) {
            t.join();
        }

        System.out.println(results);

    }

    public static void main3(String[] args) throws InterruptedException {

//      Удовлетворительное решение

        SlowMeter meter = new SlowMeter();
        int[] n = {1,2,3,4,5,6,7,8,9};
        List<Integer> results = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();

        Arrays.stream(n).forEach(i -> {
            Thread thread = new Thread(() -> {
                int result = meter.measure(i);
//              В этом месте потокоопасный код.
//              Поэтому используется lock
                lock.lock();
                results.add(result);
                lock.unlock();
            });
            thread.start();
        });

//        Дешево и сердито
//        Thread.sleep(3500);

        //Относительно хороший спопособ
        // определить окончание работы всех потоков
        boolean all_done = false;
        while(!all_done) {
            lock.lock();
            all_done = (results.size() == 9);
            lock.unlock();
            Thread.sleep(100);
        }


        //Задача: отсортируйте результаты по убыванию,
        //используя современные методы
        List<Integer> sorted_results = results.stream()
                            .sorted((x,y) -> y.compareTo(x))
                            .collect(Collectors.toList());
        System.out.println(sorted_results);

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
