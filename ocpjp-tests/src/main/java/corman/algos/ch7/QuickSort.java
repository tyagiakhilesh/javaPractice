package corman.algos.ch7;


public class QuickSort
{
    
    private <T extends Comparable > int partition( T[] array, int start, int end )
    {
        //chose a random pivot element
        T x = array[end];
        //Loop Invarient:
        // At any time, there are four regions mantainted by loop invarient in the array:
        //1. region of array, where elements are < pivot
        //2. region of array, where elements are > pivot
        //3. pivot element itself
        //4. elements which have not been put in any of the regions yet
        int i = start - 1;
        //run through entire array keeping the loop invarient true all the time
        for ( int j = 0; j < end - 1; j++ )
        {
            if ( array[j].compareTo( x ) < 0 )
            {
                i++;
                swap(array, i, j);
            }
        }
        
        //finally, put the pivot in its place where it satisfies the 
        // requirement of array's partion required by quick sort
        // i.e A[p..i] <= pivot and
        // A[i+2...r] >= pivot
        swap(array, i+1, end );
        //return position of pivot
        return i + 1;
    }
    
    private <T> void swap( T[] a, int i1, int i2 )
    {
        T tmp = a[i1];
        a[i1] = a[i2];
        a[i2] = tmp;
    }
    
    public <T extends Comparable<T> > void quickSort( T[] array, int start, int end )
    {
        if ( start < end )
        {
            int q = partition( array, start, end );
            quickSort(array, start, q - 1);
            quickSort(array, q + 1, end);
        }
        
    }
    
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        Integer[] array = {2, 8, 7, 1, 3, 5, 6, 4};
        System.out.printf("");
    }
}
