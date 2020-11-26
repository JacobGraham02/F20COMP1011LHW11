package ThreadExamples;

import ThreadExamples.EarlyMorningRunnable;
import ThreadExamples.GoodMorningThread;

public class ThreadsExample {
    public static void main(String[] args)
    {
        Thread t1 = new GoodMorningThread();
        EarlyMorningRunnable r1 = new EarlyMorningRunnable();


        t1.start();
        r1.run();

        for (int i = 1; i<=10; i++)
        {
            System.out.printf("Doing process 1, task #: %2d on thread: %s%n", i,
                    Thread.currentThread());
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
