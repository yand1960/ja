package my.testdb;

import java.sql.*;

public class Tester {
    public static void main(String[] args) throws SQLException {
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
