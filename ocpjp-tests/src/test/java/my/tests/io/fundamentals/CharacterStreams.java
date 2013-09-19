package my.tests.io.fundamentals;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

public class CharacterStreams
{
    @Test
    public void test()
    {
        Reader r = null;
        Writer w = null;
        fail( "Not yet implemented" );

        try (BufferedReader reader = new BufferedReader( new FileReader( "/tmp/a" ) );
                BufferedWriter writer = new BufferedWriter( new FileWriter( "/tmp/q" ) ))
        {
        }
        catch( IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
