package my.boot;

import org.springframework.stereotype.Component;

public class CounterBean {
    private int counter = 0;
    public int incAndGet() {
        counter += 1;
        return counter;
    }

}
