package models;

import databases.DBConnect;
import entity.ProductAndCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel implements HandleProduct {
    private Connection connection;

    public ProductModel() throws ClassNotFoundException {
        DBConnect dbConnection = new DBConnect();
        this.connection = dbConnection.getConnection();
    }


    public List<ProductAndCategory> findAll() throws SQLException, ClassNotFoundException {
        List<ProductAndCategory> productAndCategories = new ArrayList<>();
        String sql = "call list_product()";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ProductID");
            String name = rs.getString("ProductName");
            double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");
            String color = rs.getString("color");
            String category_name = rs.getString("CategoryName");
            productAndCategories.add(new ProductAndCategory(id , name, price, quantity, color, category_name));
        }
        return productAndCategories;
    }

    public void add(ProductAndCategory productAndCategory) throws SQLException {
        String sql = "call add_product(?,?,?,?,?,?)";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(1, productAndCategory.getName());
        ps.setDouble(2, productAndCategory.getPrice());
        ps.setInt(3, productAndCategory.getQuantity());
        ps.setString(4, productAndCategory.getColor());
        ps.setString(5, productAndCategory.getDescription());
        ps.setString(6, productAndCategory.getNameCategory());
        ps.execute();
    }


    public void delete(int id) throws SQLException {
        String sql = "call delete_product(?)";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setInt(1,id);
        ps.execute();
    }


    public void edit(ProductAndCategory productAndCategory) throws SQLException {
        String sql = "call edit_product(?,?,?,?,?,?,?)";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setInt(1, productAndCategory.getId());
        ps.setString(2, productAndCategory.getName());
        ps.setDouble(3, productAndCategory.getPrice());
        ps.setInt(4, productAndCategory.getQuantity());
        ps.setString(5, productAndCategory.getColor());
        ps.setString(6, productAndCategory.getDescription());
        ps.setString(7, productAndCategory.getNameCategory());
        ps.execute();
    }

}
