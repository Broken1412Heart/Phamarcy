package connectDB;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectDataBase {
    public static Connection con = null;
    private static ConnectDataBase instance = new ConnectDataBase();

    public static ConnectDataBase getInstance() {

        return instance;
    }

    public void connect() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=HieuThuocTay";
        String user = "sa";
        String password = "sapassword";
        con = java.sql.DriverManager.getConnection(url, user, password);
    }

    public void disconnect() {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return con;
    }

//     test connection
//     public static void main(String[] args) throws SQLException {
//     ConnectDataBase.getInstance().connect();
//     if (ConnectDataBase.getConnection() != null) {
//     System.out.println("Connect success");
//     } else {
//     System.out.println("Connect fail");
//     }
//     }
}
