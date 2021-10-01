package my.events;

import java.util.ArrayList;
import java.util.List;

public class SlowClassWithCallback {

    private List<ProgressListener> progressListeners = new ArrayList<>();
    private List<CompletedListener> completedListeners = new ArrayList<>();

    public void addProgressListener(ProgressListener listener) {
        progressListeners.add(listener);
    }

    public void addCompletedListener(CompletedListener listener) {
        completedListeners.add(listener);
    }

    public int slow() throws InterruptedException {
        for(int i=0; i<=100; i++) {
            Thread.sleep(100);
            final int percent = i;
            progressListeners.forEach(listener -> {
                listener.progress(percent);
            });
        }

        final int result = 12345;

        completedListeners.forEach(listener -> {
            listener.completed(result);
        });

        return result;
    }

}
