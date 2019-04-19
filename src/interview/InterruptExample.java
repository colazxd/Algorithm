package interview;

public class InterruptExample implements Runnable {
    @Override
    public void run() {
        while (!Thread.interrupted()) {

        }
    }
}
