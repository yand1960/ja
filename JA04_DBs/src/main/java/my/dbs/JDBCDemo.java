package my.dbs;

import java.sql.*;

public class JDBCDemo {

    public static void main(String[] args) throws SQLException {
        String filter = "b";
        try(Connection cn =
                    DriverManager.getConnection(
                            "jdbc:sqlserver://yand.dyndns.org;databaseName=AdventureWorks;"
                                    + "encrypt=false;trustServerCertificate=true",
                            "northwind","northwind")) {

            String sql = "SELECT ProductID, Name, ProductNumber, ListPrice " +
                    "FROM Production.Product WHERE Name LIKE ? ";
            PreparedStatement stat = cn.prepareStatement(sql);
            stat.setString(1, filter + "%");
            try(ResultSet rs = stat.executeQuery()) {
                while(rs.next()) {
                    System.out.println(rs.getString("Name") + " "
                            + rs.getDouble("ListPrice"));
                }
            }
        }
    }

    public static void main1(String[] args) throws SQLException {
        try(Connection cn =
            DriverManager.getConnection(
              "jdbc:sqlserver://yand.dyndns.org;databaseName=AdventureWorks;"
                      + "encrypt=false;trustServerCertificate=true",
                    "northwind","northwind")) {

            String sql = "SELECT ProductID, Name, ProductNumber, ListPrice " +
                    "FROM Production.Product";
            Statement stat = cn.createStatement();
            try(ResultSet rs = stat.executeQuery(sql)) {
                while(rs.next()) {
                    System.out.println(rs.getString("Name") + " "
                            + rs.getDouble("ListPrice"));
                }
            }

        }
    }
}
