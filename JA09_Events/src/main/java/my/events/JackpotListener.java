package my.events;

@FunctionalInterface
public interface JackpotListener {
    void jackpot(Double amount);
}
