package controllers;

import services.ProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.SQLException;

@WebServlet(name="BookServlet", urlPatterns ={"/product/*"})
public class ProductServlet extends HttpServlet {
    private ProductService productService;

    public void init(ServletConfig config) throws ServletException {

        try {
            this.productService = new ProductService();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException {
        req.setCharacterEncoding("utf-8");
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                try {
                    this.productService.renderPageListProduct(req, resp);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/create":
                this.productService.renderPageCreateProduct(req, resp);
                break;
            case "/delete":
                try {
                    this.productService.renderPageDeleteProduct(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/edit":
                try {
                    this.productService.renderPageEditProduct(req, resp);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException {
        req.setCharacterEncoding("utf-8");
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                try {
                    this.productService.createProduct(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/edit":
                try {
                    this.productService.editProduct(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
}
