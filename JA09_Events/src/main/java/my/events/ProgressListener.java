package my.events;

@FunctionalInterface
public interface ProgressListener {
    void progress(int percent);
}
