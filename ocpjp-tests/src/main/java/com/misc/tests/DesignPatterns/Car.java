public abstract class Car
{
    String model;
    String make;
    String warrenty;

    @override
    public String toString()
    {
        System.out.printf("Model is %s, Make is %s, Warrenty is %s years", model, make, warrenty);
    }
}
