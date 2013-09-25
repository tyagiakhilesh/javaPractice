public class DefArrayVals
{
    public static void main(String[] args)
    {
        int[] aInt = new int[2];
        System.out.printf("First element of non initialized array of int is : %d%n", aInt[0]);
        char[] achar = new char[2];
        System.out.printf("First element of non initialized array of char is : %c%n", achar[0]);
        float[] afloat = new float[2];
        System.out.printf("First element of non initialized array of float is : %g%n", afloat[0]);
        double[] adouble = new double[2];
        System.out.printf("First element of non initialized array of double is : %g%n", adouble[0]);
        Object[] aObject = new Object[2];
        System.out.println("First element of non initialized array of Object is : " + aObject[0]);
    }
}
