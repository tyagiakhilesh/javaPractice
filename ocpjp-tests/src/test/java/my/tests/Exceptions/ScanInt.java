package my.tests.Exceptions;

import java.nio.channels.AcceptPendingException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.Test;

public class ScanInt
{
    @Test
    public void test()
    { 
        System.out.println( "Type an integer in the console: " );
        Scanner consoleScanner = new Scanner( System.in );
        try
        {
            try
            {
                System.out.println( "You typed the integer value: " + consoleScanner.nextInt() );
            }
            catch( InputMismatchException ile )
            {
                AcceptPendingException e = new AcceptPendingException();
                e.initCause( ile );
                throw e;
            }
        }
        catch( Exception e )
        {
            System.out.printf( "The original cause of Exception is %s%n", e.getCause() );
            System.out.printf( "The Class of Exception received in caller %s%n", e.getClass() );
        }
        finally
        {
            consoleScanner.close();
        }
    }
    
    @Test
    public void tryWithResource()
    {
        System.out.println( "Type an integer in the console: " );
        try
        {
            /**
             * XXX note this here
             */
            try (Scanner consoleScanner = new Scanner( System.in );)
            {
                System.out.println( "You typed the integer value: " + consoleScanner.nextInt() );
            }
            catch( NoSuchElementException nel )
            {
                throw new Exception( nel.getMessage(), nel );
            }
        }
        catch( Exception e )
        {
            System.out.printf( "Error %s%n", e.getMessage() );
            System.out.printf( "The original cause of Exception is %s%n", e.getCause() );
            System.out.printf( "The Class of Exception received in caller %s%n", e.getClass() );
        }
    }
    
    @Test
    public void testThrows()
    {
        throw new RuntimeException();
        // throw new Exception() won't compile
    }
}
