package my.tests.io.fundamentals;

import my.tests.io.fundamentals.SleepTest;

public class Sleep
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        SleepTest s = new SleepTest();
        new Thread( s ).start();
    }
}
