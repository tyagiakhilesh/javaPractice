package my.tests.generics.and.collections;

import java.util.Arrays;

import org.junit.Test;

public class ArraysAsListNotUsedOnPrimitveTypesArrays
{
    @Test
    public void test()
    {
        int[] array = {10, 11, 12, 14 };
        System.out.println( "Array is (printed from asList ) " + Arrays.asList( array ));
        System.out.println( "Array is (printed from toString) " + Arrays.toString( array ));
    }
}
