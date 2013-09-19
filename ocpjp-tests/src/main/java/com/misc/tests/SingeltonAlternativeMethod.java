package com.misc.tests;

public class SingeltonAlternativeMethod
{
    private SingeltonAlternativeMethod()
    {
        // private constructor
    }

    public static SingeltonAlternativeMethod myInstance;

    public static SingeltonAlternativeMethod getInstance()
    {
        if ( myInstance == null )
        {
            synchronized ( SingeltonAlternativeMethod.class )
            {
                if ( myInstance == null )
                {
                    myInstance = new SingeltonAlternativeMethod();
                }
            }
        }
        return myInstance;
    }
}
