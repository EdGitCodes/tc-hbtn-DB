import java.sql.*;

public class ConnectionSQLite {

    public static void main(String[]args) throws SQLException {
        initConnection();
    }
    public static void initConnection() throws SQLException {
        Connection con = null;
        String dataBaseName = "sqlite_database_2022.db/";
        String dataBasePrefix = "jdbc:sqlite:/";
        String hostName = "localhost:";
        String dataBasePort = "3036/";

        try {
            if (con == null) {
                try {
                    String url = dataBasePrefix + hostName + dataBaseName;
                    con = DriverManager.getConnection(url);
                } catch (SQLException e) {
                    System.out.println("Driver nao foi achado");
                }
            }
        } finally {
            if(con != null)
            con.close();
        }
    }

}
