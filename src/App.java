import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        test.connect();
        
    }
}
class test {
    public static void  connect () throws Exception{
        Connection con = null;            
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting..");
        //con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/", "root", "");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "toor");
        System.out.println("Connected");
        Statement stmt=con.createStatement();  
        stmt.executeQuery("USE university;");
        ResultSet rs = stmt.executeQuery("SELECT * FROM course;");
        while(rs.next())  
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
        con.close();

    }
}
