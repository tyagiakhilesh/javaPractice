package my.tests.string;

import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import org.junit.Test;

public class IPAddressRegEx
{
    private String subRegEx = "((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)(\\.)){3}";
    private String regEx = "\\b"+ subRegEx + "(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\b";

    @Test
    public void test1()
    {
        assertTrue( Pattern.matches( regEx, "192.168.111.112" ) );
        assertTrue( Pattern.matches( regEx, "192.168.111.11" ) );
        assertTrue( Pattern.matches( regEx, "1.1.111.11" ) );
        assertTrue( Pattern.matches( regEx, "255.255.255.255" ) );
        assertTrue( ! Pattern.matches( regEx, "256.255.255.255" ) );
    }
}
