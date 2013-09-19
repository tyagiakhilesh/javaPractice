package my.tests.concurrency.interfacesandabstract;

import java.nio.file.FileSystemException;

public abstract class B
{
    B()
    {
        super();
    }
    
    static public void f() throws FileSystemException {}
    abstract public void a();
    
    abstract public void c();
    
    public void d() 
    {
        
    }
}
