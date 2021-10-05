package my.aop;

import org.springframework.stereotype.Component;

@Component("calc")
public class Calc {
    public int plus(int x, int y) {
        return x + y;
    }

    public int minus(int x, int y) {
        return x - y;
    }
}
