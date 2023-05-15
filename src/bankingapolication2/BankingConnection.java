package bankingapolication2;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author dol
 */
public class BankingConnection {

    public static Connection connect() {
        String url = "jdbc:mysql://localhost:8889/mydb2";
        String usr = "root";
        String paswd = "root";

        Connection conn = null;

        try {
            /*
                Load mysql driver.
             */
            Class.forName("com.mysql.cj.jdbc.Driver");

            /*
                Connect to DB server.
             */
            conn = DriverManager.getConnection(url, usr, paswd);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BankingConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BankingConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
