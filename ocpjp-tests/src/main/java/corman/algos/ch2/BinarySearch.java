package corman.algos.ch2;

import java.util.Arrays;

public class BinarySearch
{
   public static <T extends Comparable<T> > int search ( T key, T[] sortedArray)
    {
        if ( sortedArray.length == 0 )
            return 0;
        
        if ( key.compareTo( sortedArray[sortedArray.length / 2] ) == 0 )
        {
            return sortedArray.length / 2;
        }
        else if ( key.compareTo( sortedArray[sortedArray.length / 2] ) < 0 )
        {
            return search( key, Arrays.copyOfRange( sortedArray, 0, (sortedArray.length / 2 - 1) ));
        }
        else if ( key.compareTo( sortedArray[sortedArray.length / 2] ) > 0 )
        {
            return search( key, Arrays.copyOfRange( sortedArray, (sortedArray.length / 2 + 1), sortedArray.length ));
        }
        return -1;
    }
}
