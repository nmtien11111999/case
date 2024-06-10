package services;

import entity.ProductAndCategory;
import models.ProductModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ProductService extends HttpServlet {
    private ProductModel productmodel;

    public ProductService() throws ClassNotFoundException {
        this.productmodel = new ProductModel();
    }
    public void renderPageListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        List<ProductAndCategory> product = this.productmodel.findAll();
        request.setAttribute("product", product);
        RequestDispatcher out = request.getRequestDispatcher("/view/list.jsp");
        out.forward(request, response);
    }

    public void renderPageCreateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher out = req.getRequestDispatcher("/view/create.jsp");
        out.forward(req, resp);
    }

    public void renderPageDeleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        this.productmodel.delete(id);
        resp.sendRedirect("/product/list");
    }

    public void renderPageEditProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        List<ProductAndCategory> product = this.productmodel.findAll();
        req.setAttribute("product", product);
        RequestDispatcher out = req.getRequestDispatcher("/view/edit.jsp");
        out.forward(req, resp);
    }

    public void createProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String description = req.getParameter("description");
        String category = req.getParameter("category");
        ProductAndCategory product = new ProductAndCategory(id, name, price, quantity, description, category);
        this.productmodel.add(product);
        resp.sendRedirect("/product/list");
    }

    public void editProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        String description = req.getParameter("description");
        String category = req.getParameter("category");
        ProductAndCategory productAndCategory = new ProductAndCategory(id, name, price, quantity,color, description, category);
        this.productmodel.edit(productAndCategory);
        resp.sendRedirect("/product/list");
    }
}
