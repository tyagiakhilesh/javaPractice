package my.tests.generics.and.collections;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AddingElementToListReturnedByArraysUtilAsList
{
    @Test(expected=UnsupportedOperationException.class)
    public void test()
    {
        int[] myArray = {10, 11 };
        List<?> list = Arrays.asList( myArray );
        /*
         * modifying a read only list shall throw 
         * UnsupportedOperationException exception
         */
        list.add(1, null);
    }
    
    @Test
    public void test1()
    {
        String[] myArray = {"10", "11" };
        List<String> list = Arrays.asList( myArray );
        System.out.println("Modified array, is" + Arrays.toString( myArray ));
    }
}
