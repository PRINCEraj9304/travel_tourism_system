
package travel.management.systemm;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    // there are 5 steps in jdbc
    Conn(){
       try{
           // 1st step of jdbc is register the driver which is mysql here.
           
           Class.forName("com.mysql.cj.jdbc.Driver"); // providing the address of driver class which is in libraries folder and we are 
           // registiring the driver class
           
           // strp 2 = creating connection string
           
           c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem", "root","Prince#9304raj");  // we will pass username, password of sql which will we use
           
           // step 3  = creating the statement;
           s = c.createStatement();
           // step 4 = excuting the mysql queries
           // setp 5 = closing the connection
           
       }
       catch(Exception e){
           e.printStackTrace();
       }
       // we use try catch syntax bcz mysql is external file so there may be error
    
}
}
