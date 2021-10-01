package my.events;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        DemoClassWithEvent dcwe = new DemoClassWithEvent();
        dcwe.addJackpotListener(amount -> {
            System.out.println("Wow! I won " + amount.toString());
        });

        System.out.println(dcwe.plus(1, 2));
        System.out.println(dcwe.plus(776, 1));

        SlowClassWithCallback scwc = new SlowClassWithCallback();
        //System.out.println(scwc.slow()); //так сучно

        //А так веселее:
        scwc.addProgressListener(percent -> {
            System.out.println("" + percent + "%");
        });

        scwc.addCompletedListener(result -> {
            System.out.println("Result: " +result);
        });

        scwc.slow();
    }
}
