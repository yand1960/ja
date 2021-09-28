package my.threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SlowMeter {

    // Executorы снимают с девлопера заботу
    // о явном контроле над потоками b и обеспечивают
    // синтаксически изящные мтетоды написания асинхронного кода
    private ExecutorService executor
            = Executors.newFixedThreadPool(20);

    public int measure(int n) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = 10 * n;
        return result;
    }

//    "Асинхронная обертка" над синхронным методом
//    Future - это родственник Task в С# и Promise в JS
    public Future<Integer> measureAsync(int n) {
        return executor.submit(() -> measure(n));
    }


    public void shutdown() {
        executor.shutdown();
    }
}
