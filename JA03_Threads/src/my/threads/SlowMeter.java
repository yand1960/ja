package my.threads;

public class SlowMeter {
    public int measure(int n) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = 10 * n;
        return result;
    }
}
