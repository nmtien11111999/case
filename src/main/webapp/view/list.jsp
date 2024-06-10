
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 5/30/2024
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Danh sách sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="card my-5">
        <div class="card-header">
            <h1>Danh sách sản phẩm</h1>
        </div>
        <div class="card-body">
            <div class="text-end mb-2">
                <a href="http://localhost:8080/product/create" class="btn btn-primary btn-sm">Add new Product</a>
            </div>
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Color</th>
                    <th>Category</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${product}" var="product">
                    <tr>
                        <td class="text-center">${product.id}</td>
                        <td>${product.name}</td>
                        <td class="text-end">${product.price}</td>
                        <td>${product.quantity}</td>
                        <td class="text-center">${product.color}</td>
                        <td>${product.nameCategory}</td>
                    </span>
                        </td>
                        <td class="text-center">
                            <a class="btn btn-info btn-sm mx-1" href="http://localhost:8080/product/edit?id=${product.id}">Edit</a>
                            <a class="btn btn-danger btn-sm" href="http://localhost:8080/product/delete?id=${product.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
        crossorigin="anonymous"></script>
</body>
</html>
