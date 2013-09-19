package com.misc.tests;

import org.junit.Test;

public class TestDefValOfUnInitFields
{
    @Test
    public void test()
    {   
        FieldsDefValueIfNotDefined f = new FieldsDefValueIfNotDefined();
        System.out.println(f.x + " " + f.o);
    }
}
