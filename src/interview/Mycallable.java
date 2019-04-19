package interview;

import java.util.concurrent.Callable;

public class Mycallable implements Callable<Integer> {
    public Integer call() {
        return 123;
    }
}
