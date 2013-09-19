package com.misc.tests;

public class SingeltonBestDesign
{
    private SingeltonBestDesign() {}
    
    public static SingeltonBestDesign getInstance()
    {
        return RefHolder.object;
    }
    
    private static class RefHolder
    {
        public static SingeltonBestDesign object = new SingeltonBestDesign();
    }
}
