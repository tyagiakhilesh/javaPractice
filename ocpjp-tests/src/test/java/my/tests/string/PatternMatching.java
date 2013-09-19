package my.tests.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class PatternMatching
{
    Pattern pattern = null;
    Matcher matcher = null;
    final static String str = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Milestone, " +
    		"Hugo-city 56010, Ph: 9876543210, Email: danny@myworld.com. Maggi Myer, Post bag no 52, " +
    		"Big bank post office,Big bank city 56000, ph: 9876501234, Email: maggi07@myuniverse.com.";

    private void func( String apattern )
    {
        pattern = Pattern.compile(apattern);
        matcher = pattern.matcher( str );
        while ( matcher.find() )
        {
            System.out.println( matcher.group() );
        }
    }
    
    @Test
    public void writeAllWordsOfString()
    {
        func("\\w+");
    }
    
    @Test
    public void printBackslashInJava()
    {
        System.out.println("Printing backslash" + "\\");
    }
    
    @Test
    public void printZipCodes()
    {
        func("\\b\\d{5}\\b");
    }
    
    @Test
    public void printAllPhoneNumbers()
    {
        func("\\b\\d{10}\\b");
    }
    
    /**
     * Look out for use of $x for group reference
     */
    @Test
    public void alterPhoneNumFormat()
    {
        Pattern p = Pattern.compile("\\b(\\d{3})(\\d{7})\\b");
        Matcher m = p.matcher( str );
        String s = m.replaceAll( "$1-$2" );
        System.out.println( "Input with PhNum format changed is : " + s);
    }
}
