import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCConnect
{
    public static void main(String[] args) throws NullPointerException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/umuzi/";
        String user = "root";
        String password = "zoba";
        ArrayList sql = new ArrayList();
        {
            try
            {
                Connection con = DriverManager.getConnection(url,user,password);
                Statement mystmt = con.createStatement();
                sql.add(1,"select * from umuzi.customer");
                sql.add(2,"select Firstname from umuzi.customer");
                sql.add(3,"select Firstname from umuzi.customer where CustomerID=1");
                sql.add(4,"update umuzi.customer set Firstname='Lerato',Lastname='Mabisto' where CustomerID=1");
                sql.add(5,"delete from umuzi.customer where CustomerID=2");
                sql.add(6,"select count(distinct Status)from umuzi.orders");
                sql.add(7,"select concat('R',max(Amount))as 'maximum payment'from umuzi.payment");
                ResultSet result = mystmt.executeQuery(String.valueOf(sql));

                while (result.next())
                {
                    System.out.println(result.getString("Firstname"));
                }
                mystmt.close();
                con.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    }

}
