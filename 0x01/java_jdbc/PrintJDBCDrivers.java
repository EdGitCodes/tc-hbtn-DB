import java.sql.*;
import java.util.Enumeration;

public class PrintJDBCDrivers {
    public static void main(String[]args){
        Enumeration<Driver> drivers = DriverManager.getDrivers();

        while(drivers.hasMoreElements()){
         Driver driver = drivers.nextElement();
            System.out.println(driver.getClass() + " "+ driver.getMinorVersion()+" - " +driver.getMajorVersion());
        }
    }
}
