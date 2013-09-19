package my.tests.concurrency.interfacesandabstract;

public class C extends B
{
    @Override
    public void a()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void c()
    {
        // TODO Auto-generated method stub
    }
    
    public void q() {}
    public void q(Number n) { System.out.println("Number");}
    public void q(Integer i) { System.out.println("Integer"); }
    public void q(int i) { System.out.println("int"); }
    public void q(short i) { System.out.println("short"); }
    public void q(Object o) { System.out.println("Object"); }
    
    public static void main(String[] args)
    {
        
        C c = new C();
        c.q(10);
    }
}
