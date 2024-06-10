<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 5/30/2024
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container shadow">
    <form action="/product/edit" method="post">
        <div class="cart my-5">
            Name<input type="text" name="id" readonly placeholder="id" value="${product.id}" class="btn-sm mb-3 form-control">
            Name<input type="text" name="name"  placeholder="id" value="${product.name}" class="btn-sm mb-3 form-control">
            price<input type="text" name="price" placeholder="name" value="${product.price}" class="mb-3 form-control">
            quantity<input type="text" name="quantity" placeholder="price" value="${product.quantity}" class="mb-3 form-control">
            Description<input type="text" name="description" placeholder="description" value="${product.description}" class="mb-3 form-control">
            Category<input type="text" name="category" placeholder="category" value="${product.category}" class="mb-3 form-control">
            <br>
            <button class="btn btn-primary w-100">Edit</button>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
