package my.tests.concurrency;

import static org.junit.Assert.fail;

import java.nio.IntBuffer;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Lock;

import org.junit.Test;

public class ProducerConsumerTests
{
    @Test
    public void testUsingLockInterface()
    {
        class Producer implements Runnable
        {
            IntBuffer buffer = null;
            Lock lock = null;
            

            public Producer( IntBuffer buffer, Lock lock )
            {
                this.buffer = buffer;
                this.lock = lock;
            }

            @Override
            public void run()
            {
                int count = 0;
                lock.lock();
                buffer.put( count++ );
                System.out.printf("Produced element %d for buffer%n", count);
                lock.unlock();
            }
            
        }
        
        class Consumer implements Runnable
        {
            IntBuffer buffer = null;
            Lock lock = null;
            

            public Consumer( IntBuffer buffer, Lock lock )
            {
                this.buffer = buffer;
                this.lock = lock;
            }

            @Override
            public void run()
            {
                int count = 0;
                lock.lock();
                //System.out.printf( "Removed element %d from queue%n", buffer.poll() );
                lock.unlock();
            }
            
        }
        
        Queue <Integer> q = new ArrayDeque<>();
        fail( "Not yet implemented" );
    }
}
