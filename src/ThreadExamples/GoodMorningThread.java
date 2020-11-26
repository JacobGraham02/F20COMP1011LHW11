package ThreadExamples;

public class GoodMorningThread extends Thread {
    public void run()
    {
        //this is where we put the Thread code
        //it could be system call, an API call, some chunk of heavy
        //process
        for (int i = 1; i<=10; i++)
        {
            System.out.printf("Doing process 2, task #: %2d on thread: %s%n", i,
                    Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
