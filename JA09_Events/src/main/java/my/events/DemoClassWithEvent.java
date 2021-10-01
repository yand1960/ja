package my.events;

import java.util.ArrayList;
import java.util.List;

public class DemoClassWithEvent {

    private List<JackpotListener> jackpotListeners = new ArrayList<>();
    public void addJackpotListener(JackpotListener jackpotListener) {
        jackpotListeners.add(jackpotListener);
    }

    //Нужен еще removeJackpotListener, но я писать его не буду

    public int plus(int x, int y) {
        int result = x + y;
        if(result == 777) {
            jackpotListeners.forEach( listener -> {
                listener.jackpot(1000000.0);
            });
        }
        return result;
    }

}

//public class DemoClassWithEvent {
//
//    private JackpotListener jackpotListener;
//    public void addJackpotListener(JackpotListener jackpotListener) {
//        this.jackpotListener = jackpotListener;
//    }
//
//    public int plus(int x, int y) {
//        int result = x + y;
//        if(result == 777) {
//            if(jackpotListener != null)
//                jackpotListener.jackpot(1000000.0);
//        }
//        return result;
//    }
//
//}
