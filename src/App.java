import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        db.connect();
        
    }
}
class db {
    public static void  connect () throws Exception{
        //int col;
        //String cmd = "",c;
        Connection con = null;            
        Class.forName("com.mysql.cj.jdbc.Driver"); // loading the driver
        
        // CREATE USER 'billing'@'localhost' IDENTIFIED BY 'billing';
        // GRANT ALL PRIVILEGES ON * . * TO 'newuser'@'localhost';

        // establishing the connection
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billdb", "billing", "billing");
        System.out.println("Connected");

        // creating statemtent object
        Statement stmt=con.createStatement();

        // CREATE TABLE products(id int PRIMARY KEY,name varchar(50),price float,available boolean);

        // storing the resultant relation in resultset
        ResultSet rs = stmt.executeQuery("SELECT * FROM products");

        /*col = rs.getInt(1);
        for(int i = 1; i<=col;i++){
            c = String.format("rs.getString(%d) + \" \"", i);
            cmd += c;
        } This didn't work!!!*/

        while(rs.next())  
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4));  
        con.close();
    }
}

/*
> javac -cp mysql-connector-java-8.0.26.jar App.java 
> java -cp mysql-connector-java-8.0.26.jar App.java 
Hello, World!
Connected
1  Kitkat 30g  45.0 1
*/