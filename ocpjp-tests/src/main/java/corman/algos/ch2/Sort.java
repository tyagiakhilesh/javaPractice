package corman.algos.ch2;

import java.util.Arrays;


/**
 * Algorithm is
 * 
 for j=2 to lenght of Array
 *      key <- A[j]
 *      i <- j-1 // note while inserting into sorted array, you are going backwards
 *      // insert key into already sorted array
 *      while i > 0 and A[i] < key (for sorting in decreasing order) ( or A[i] > key for increasing order)
 *          A[i+1] <- A[i] // right shift value in sorted array
 *          i <- i-1
 *          
 *       A[i] = key // insert key into its valid place in sorted array
 * 
 * @author parallocity
 * 
 */
public class Sort
{
    public static <T extends Comparable<T>> T[] insertionSort( T[] inputArray, boolean ascending )
    {
        long startTime = System.currentTimeMillis();
        
        int i;
        for ( int j = 1; j < inputArray.length; j++ )
        {
            T key = inputArray[j]; // Store key element
            i = j - 1;
            while ( i >= 0 )
            {
                if ( (ascending) ? (inputArray[i].compareTo( key ) >= 0) : (inputArray[i].compareTo( key ) <= 0) )
                {
                    inputArray[i + 1] = inputArray[i]; // Right shift elements
                    i--;
                }
                else
                {
                    //found a proper place for insertion of key
                    break;
                }
            }
            inputArray[i + 1] = key;
        }
        
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        
        System.out.printf("Total time taken for sorting via Insertion Sort is %d miliseconds %n", totalTime);
        
        return inputArray;
    }
    
    public static <T extends Comparable<T>> T[] optimizedInsertionSort( T[] inputArray )
    {
        long startTime = System.currentTimeMillis();
        
        int i;
        for ( int j = 1; j < inputArray.length; j++ )
        {
            T key = inputArray[j]; // Store key element
            i = BinarySearch.search( key, Arrays.copyOfRange(inputArray, 0, j-1) );
            // still need to shift right!!
            for ( int k = i; i < inputArray.length - 1; i ++)
            {
                inputArray[i + 1] = inputArray[i];
            }
            inputArray[i] = key;
        }
        
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        
        System.out.printf("Total time taken for sorting via optimizedInsertionSort Sort is %d miliseconds %n", totalTime);
        
        return inputArray;
    }
    
    public static <T extends Comparable<T> > T[] selectionSort( T[] inputArray, boolean ascending )
    {
        for ( int j = 0; j < (inputArray.length - 1); j++ )
        {
            int i = j;
            int indexOfkey = i;
            T key = inputArray[i];
            
            while ( i < inputArray.length )
            {
                if ( (ascending) ? (inputArray[i].compareTo( key ) <= 0) : (inputArray[i].compareTo( key ) >= 0) )
                {
                    key = inputArray[i];
                    indexOfkey = i;
                }
                i++;
            }
            
            T tmp = inputArray[j];
            inputArray[j] = key;
            inputArray[indexOfkey] = tmp;
            
        }
        return inputArray;
    }
}
