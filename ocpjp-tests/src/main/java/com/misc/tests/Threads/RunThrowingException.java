public class RunThrowingException extends Thread
{
    public void run()
    {
        throw new RuntimeException();
    }

    public static void main(String[] args)
    {
        new RunThrowingException().start();
        try
        {
            sleep(1000);
        }
        catch (InterruptedException e)
        {
            System.out.println("interrupted");
        }
        System.out.println("main thread");
    }
}
