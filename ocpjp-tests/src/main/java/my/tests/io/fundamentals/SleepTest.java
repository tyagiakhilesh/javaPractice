package my.tests.io.fundamentals;

public class SleepTest implements Runnable 
{
    @Override
    public void run()
    {
        try
        {
            System.out.println("Sleeping now");
            Thread.sleep( 10000 );
        }
        catch( InterruptedException e )
        {
            System.out.println("Sleep interrupted");
        }
    }
}
