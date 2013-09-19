package my.tests.concurrency;

import java.util.concurrent.Semaphore;

import org.junit.Test;

public class HighLevelConcurrencyConstructs
{
    private class Person extends Thread
    {
        private String name;
        private Semaphore machines;
        
        public Person( Semaphore machines, String name )
        {
            this.machines = machines;
            this.name = name;
            this.start();
        }
        
        @Override
        public void run()
        {
            try
            {
                System.out.printf("Person %s is Wating in queue%n", this.name);
                machines.acquire();
                System.out.printf("Person %s is working on machine%n", this.name);
                //this.doSomething();
                sleep(10000);
                System.out.printf("Person %s is Done with machine%n", this.name);
                machines.release();
            }
            catch( InterruptedException e )
            {
                System.out.printf("Person %s interrupted when trying to acquire access to machine%n", this.name);
            }
        }

        private void doSomething()
        {
            try
            {
                Thread.currentThread().sleep( 10000 );
            }
            catch( InterruptedException e )
            {
                System.out.printf("Person %s interrupted when working on machine", this.name);
            }
        }
        
    }
    
    @Test
    public void testSemaphore()
    {
        // assume that only two ATM machines are available in the ATM room 
        Semaphore machines = new Semaphore(2); 
        
        // list of people waiting to access the machine 
        Person p1 = new Person(machines, "Mickey");
        Person p2 = new Person(machines, "Donald");
        Person p3 = new Person(machines, "Tom");
        Person p4 = new Person(machines, "Jerry");
        Person p5 = new Person(machines, "Casper");
    
        try
        {
            p1.join();
            p2.join();
            p3.join();
            p4.join();
            p5.join();
        }
        catch( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
