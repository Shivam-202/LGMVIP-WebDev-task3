package Students_Management;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

 
 
         public static Connection dbconnect(){
       Connection cons =null;
     
        try {
           
                   Class.forName("com.mysql.jdbc.Driver");
                    
                   cons = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedetails","root","");
                  
        } catch (Exception ex) {  System.out.println(ex); }    
      
        return(cons);
         }
public static void main(String[] args){
    dbconnect();
}
      
}


