package com.misc.tests;

public class InnerClassInstantiation
{
    InnerClassInstantiation()
    {
        System.out.println("Outer");
    }
    public class Inner
    {
        Inner()
        {
            System.out.println("Inner");
        }
    }

    public static void main(String[] args)
    {
        InnerClassInstantiation.Inner in = new InnerClassInstantiation().new Inner();
    }
}
