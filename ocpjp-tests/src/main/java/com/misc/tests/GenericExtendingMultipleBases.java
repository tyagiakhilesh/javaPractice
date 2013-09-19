package com.misc.tests;

import java.io.Closeable;
import java.util.Comparator;
//see use of 
public class GenericExtendingMultipleBases<T extends Comparator & Closeable>
{
        private <T> void function() {}
}
