package models;

import entity.ProductAndCategory;

import java.sql.SQLException;
import java.util.List;

public interface HandleProduct {
    public interface HandleBook {
        void add(ProductAndCategory productAndCategory) throws SQLException;
        void delete(int id) throws SQLException;
        void edit(int id,ProductAndCategory productAndCategory) throws SQLException;
        int findById(int id) throws SQLException;
        List<ProductAndCategory> findAll() throws SQLException, ClassNotFoundException;
    }
}
