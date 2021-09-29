import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        test.connect();
        
    }
}
class test {
    public static void  connect () throws Exception{
        int col;
        String cmd = "",c;
        Connection con = null;            
        Class.forName("com.mysql.jdbc.Driver"); // loading the driver
        System.out.println("Connecting..");
        //con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/", "root", "");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "toor"); // establishing the connection
        System.out.println("Connected");
        Statement stmt=con.createStatement();  // creating statemtent object
        stmt.executeQuery("USE billing;");
        // information_schema provides access to database metadata
        ResultSet rs = stmt.executeQuery("SELECT COUNT(COLUMN_NAME) FROM information_schema.columns WHERE table_name = 'product' "); //storing the resultant relation in resultset
        rs.next();
        col = rs.getInt(1);
        for(int i = 1; i<=col;i++){
            c = String.format("rs.getString(%d) + \" \"", i);
            cmd += c;
        }
        System.out.println(cmd);

    }
}
