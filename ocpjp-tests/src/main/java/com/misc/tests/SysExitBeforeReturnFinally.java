package com.misc.tests;

public class SysExitBeforeReturnFinally
{
    public static void main( String[] args )
    {
        try
        {
            System.exit( 0 );
            System.out.println("Printing even after exit");
        }
        catch (Exception e)
        {
            
        }
        finally
        {
            System.out.println("Shall it be printed before exiting??!!");
        }
    }
}
