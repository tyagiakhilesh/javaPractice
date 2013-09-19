public class Test
{
    public static void main(String[] args)
    {
        Base b = new Derived();
        // compiler error ((Derived)b).func3();
        b.func1();
        //b.func3(); //compiler error
    }
}
