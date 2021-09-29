package my.dal;

import my.dal.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryJDBC implements Repository {

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
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
                    Product p = new Product();
                    p.setId(rs.getInt(1));
                    p.setName(rs.getString(2));
                    p.setCode(rs.getString(3));
                    p.setPrice(rs.getDouble(4));
                    products.add(p);
                }
            }
        }
        catch(Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return products;
    }
}
