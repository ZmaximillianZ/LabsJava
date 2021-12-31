package Handler;

import java.util.Scanner;

public abstract class Handler {
    public void handle(int point, Scanner scanner) throws Exception {
        for (int p: points()) {
            if (p == point) {
                run(point, scanner);
                break;
            }
        }
    }

    abstract protected int[] points();
    abstract protected void run(int point, Scanner scanner) throws Exception;
}
