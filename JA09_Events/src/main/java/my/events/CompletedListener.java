package my.events;

@FunctionalInterface
public interface CompletedListener {
    public void completed(int result);
}
