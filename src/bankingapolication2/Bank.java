package bankingapolication2;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dol
 */
public class Bank {

    private String bankname;

    public Bank(String bankname) {
        this.bankname = bankname;
    }

    public void listAccount() {
        Connection conn = BankingConnection.connect();
        String sql = "select * from mydb2.account;";

        try {
            Statement sm = conn.createStatement();
            ResultSet resultSet = sm.executeQuery("select * from mydb2.account");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1)
                        + " " + resultSet.getString(2)
                        + " " + resultSet.getString(3));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void openAccount(int accountNumber, String accountName, double accountBalanced) {
        Connection conn = BankingConnection.connect();
        String sql = "insert into account(accNumber, accName, accBalance) "
                + "values(?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accountNumber);
            ps.setString(2, accountName);
            ps.setDouble(3, accountBalanced);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeAccount(int accountNumber) {
        Connection conn = BankingConnection.connect();
        try {
            String sql = "delete from mydb2.account where accNumber=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accountNumber);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void depositMoney(int accountNumber, double amount) {
        try {
            Account acc = getAccount(accountNumber);
            acc.deopsit(amount);

            Connection conn = BankingConnection.connect();
            String sql = "update mydb2.account set accBalance=? where accNumber=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, acc.getBalance());
            ps.setInt(2, acc.getNumber());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void withdrawMoney(int accountNumber, double amount) {
        try {
            Account acc = getAccount(accountNumber);
            acc.withdraw(amount);

            Connection conn = BankingConnection.connect();
            String sql = "update mydb2.account set accBalance=? where accNumber=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, acc.getBalance());
            ps.setInt(2, acc.getNumber());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Account getAccount(int accountNumber) {
        Connection conn = BankingConnection.connect();
        String sql = "select * from mydb2.account where accNumber=?";
        Account acc = null;

        try {
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, accountNumber);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            acc = new Account(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc;
    }
}
