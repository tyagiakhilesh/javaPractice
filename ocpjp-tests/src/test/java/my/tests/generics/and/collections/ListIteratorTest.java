package my.tests.generics.and.collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;
import static org.junit.Assert.*;

public class ListIteratorTest
{
    /**
     * Check if given string reads the same from both ends
     */
    private boolean ifPlaindrom( String plaindromString )
    {
        List<Character> palindrome = new LinkedList<Character>();
        
        for ( char ch : plaindromString.toCharArray() )
        {
            palindrome.add( ch );
        }
        System.out.println( "Input string is: " + plaindromString );
        //XXX
        ListIterator<Character> iterator = palindrome.listIterator();
        //XXX
        ListIterator<Character> revIterator = palindrome.listIterator( palindrome.size() );
        
        boolean result = true;
        while ( revIterator.hasPrevious() && iterator.hasNext() )
        {
            if ( iterator.next() != revIterator.previous() )
            {
                result = false;
                break;
            }
        }
        return result;
    }
    @Test
    public void test()
    {
        assertTrue(ifPlaindrom("abcba"));
    }
}
