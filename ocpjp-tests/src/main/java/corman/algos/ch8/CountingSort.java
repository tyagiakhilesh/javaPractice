package corman.algos.ch8;

import java.util.Arrays;

public class CountingSort
{
    
    public <T extends Number> T[] countingSort( T[] inArray, T maxValInArray, T[] output )
    {
        // this statement requires that T can be casted to integer
        int[] counterArray = new int[(Integer) maxValInArray + 1];
        //initialize counterarray
        for ( int i = 0; i < counterArray.length; i++ )
        {
            counterArray[i] = 0;
        }
        //count elements in inArray and keep counts in counterArray
        for ( int i = 0; i < inArray.length; i++ )
        {
            counterArray[(Integer) inArray[i]] =  counterArray[(Integer) inArray[i]] + 1;
        }
        // after below loop, each counterArray[i] shall have count of numbers 
        // smaller or equal to ith element in inArray
        for ( int i = 1; i < counterArray.length; i++ )
        {
            counterArray[i] = counterArray[i-1] + counterArray[i];
        }
        //finally fill in the output array using counterArray 
        // XXX lenght to 0 th iteration is required to keep this 
        // sorting method STABLE (read about it if you don't know)
        // Otherwise, the algo shall work fine even for 0 to lenght 
        // looping too!!
        for ( int i = inArray.length - 1; i >=0; i-- )
        {
            output[counterArray[(Integer)inArray[i]] - 1] = inArray[i];
            counterArray[(Integer)inArray[i]] -= 1; 
        }
        return output;
    }
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        Integer[] array = {10, 3, 13, 6, 9, 0, 2, 1 };
        Integer [] out = new Integer[8];
        System.out.println("Sorted array is ");
        System.out.println(Arrays.toString( new CountingSort().countingSort( array, 13, out ) ));
        // TODO Auto-generated method stub
    }
}
