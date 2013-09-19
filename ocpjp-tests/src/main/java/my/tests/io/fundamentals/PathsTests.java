package my.tests.io.fundamentals;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class PathsTests
{
    @Test
    public void testGetName()
    {
        Path p = Paths.get( "/home/akhilesh/Desktop" );
        System.out.printf("The 0'th component is path is %s%n", p.getName( 0 ));
        System.out.printf("The 1'st component is path is %s%n", p.getName( 1 ));
        System.out.printf("The 2'nd component is path is %s%n", p.getName( 2 ));
        System.out.printf( "URL equivalent to path is %s%n", p.toUri());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void createPathUsingWrongName()
    {
        Path p = Paths.get( "\\home\\akhilesh\\Desktop" );
        p.getName(0);
    }
}
