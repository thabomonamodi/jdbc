import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class JDBCConnect
{
    public static void main(String[] args) throws NullPointerException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/umuzi?autoReconnect=true&useSSl=true";
        String user = "root";
        String password = "zoba";

        {
            tryg
            {
                Connection con = DriverManager.getConnection(url,user,password);
                Statement mystmt = con.createStatement();
                String sql = "select * from umuzi.customer";
                ResultSet result = mystmt.executeQuery(sql);

                while (result.next())
                {
                    System.out.println(result.getString("Firstname"));
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    }

}
