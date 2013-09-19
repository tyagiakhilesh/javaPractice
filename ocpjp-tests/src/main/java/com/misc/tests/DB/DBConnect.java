import java.sql.*;

public class DBConnect
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://127.0.0.1:3306/";
        String database = "practice";
        String user = "root";
        String pswd = "root123";

        //try with resource statement
        try ( Connection con = DriverManager.getConnection(url + database, user, pswd) )
        {
            System.out.println("Database connection Suceeded!!");
        }
        catch (Exception e)
        {
            System.out.println("Database connection failed!!");
            e.printStackTrace();
        }
    }
}
