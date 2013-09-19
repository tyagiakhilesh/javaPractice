package corman.algos.ch2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class InsertionSortTest
{
    final static long MAX_ELEMENTS = 10;
    Integer[] randomArray ;
    
    @Before
    public void init()
    {
        Random rng = new Random( new Date().getTime() );
        randomArray = new Integer[(int) MAX_ELEMENTS];
        for ( int i = 0; i < randomArray.length; i++ )
        {
            randomArray[i] = (rng.nextInt() / 100);
        }
    }
    
    @Test
    public void measureInsertionSortTime()
    {
        Sort.insertionSort( randomArray, true );
        //Sort.optimizedInsertionSort( randomArray);
    }
    
    @Test
    public void testInsertionSort()
    {
        System.out.printf("NonDecreasingly sorted array for %s using Insertion Sort is %n%s%n",
                Arrays.toString( randomArray ),
                Arrays.toString( Sort.insertionSort( randomArray, true ) ));
        
        System.out.printf("NonIncreasingly sorted array for %s using Insertion Sort is %n%s%n",
                Arrays.toString( randomArray ),
                Arrays.toString( Sort.insertionSort( randomArray, false ) ));
    }
    
    @Test
    public void testSelectionSort()
    {
        System.out.printf("NonDecreasingly sorted array for %s using Selection Sort is %n%s%n",
                Arrays.toString( randomArray ),
                Arrays.toString( Sort.selectionSort( randomArray, true ) ));
        
        System.out.printf("NonIncreasingly sorted array for %s using Selection Sort is %n%s%n",
                Arrays.toString( randomArray ),
                Arrays.toString( Sort.selectionSort( randomArray, false ) ));
    }
}
