package ThreadExamples;

public class EarlyMorningRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i<=10; i++)
        {
            System.out.printf("Doing process 3, task #: %2d on thread: %s%n", i,
                    Thread.currentThread());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
