package my.tests.io.fundamentals;

import java.io.Console;

import org.junit.Test;

public class ConsoleTests
{
    @Test
    public void test()
    {
        Console console = System.console();
        if(console == null) {
System.err.println("Cannot retrive console object - are you running your application from an IDE? Exiting the application ... ");
            System.exit(-1); // terminate the application 
        }
        // read a line and print it through printf  
        console.printf(console.readLine());
    }
}
