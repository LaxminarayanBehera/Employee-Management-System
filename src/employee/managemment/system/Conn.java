package employee.managemment.system;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //c=DriverManager.getConnection("jdbc:mysql/localhost:3306/guli")
            String url="jdbc:mysql://localhost:3306/employee";
            String un="root";
            String pass="root";
            c=DriverManager.getConnection(url,un,pass);
            s=c.createStatement();
    }catch(Exception e){
        e.printStackTrace();
    }
   
  }
}
