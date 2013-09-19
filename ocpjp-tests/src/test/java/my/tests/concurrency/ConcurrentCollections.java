package my.tests.concurrency;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import org.junit.Test;

public class ConcurrentCollections
{
    @Test
    public void testBlockingQueue()
    {
        BlockingQueue<String> q = new PriorityBlockingQueue<>();
        Queue<String> q1 = new ArrayDeque<>();
        try
        {
            q1.poll();
            System.out.println("Taking element from empty queue should block.");
            q.take();
        }
        catch( InterruptedException e )
        {
            System.out.println("Waiting blcoking queue interrupted");
        }
    }
}
