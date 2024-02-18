<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.eclipse.jakarta.hello.entity.Product" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Product List</title>
    <style>
        body {
            text-align: center;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
            height: 100vh;
        }

        .product-container {
            display: flex;
            align-items: center;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            padding: 10px;
            border-radius: 5px;
            width: 300px;
        }

        .product-details {
            flex: 1;
            margin-right: 10px;
        }

        .btn {
            padding: 8px 16px;
            text-decoration: none;
            background-color: #4caf50;
            color: white;
            border-radius: 5px;
        }

        .btn-delete {
            background-color: #f44336;
        }
    </style>
</head>
<body>
    <h1>Product List</h1>
    <% List<Product> products = (List<Product>) request.getAttribute("products"); %>
    <% for (Product product : products) { %>
        <div class="product-container">
            <div class="product-details">
                <strong><%= product.getName() %></strong><br>
                Price: <%= product.getPrice() %>
            </div>

            <div>
                <a href="<%= request.getContextPath() %>/delete-product?productId=<%= product.getId() %>" class="btn btn-delete">Delete</a>
                <a href="<%= request.getContextPath() %>/update-product?productId=<%= product.getId() %>" class="btn">Update</a>
            </div>
        </div>
    <% } %>

    <a href="<%= request.getContextPath() %>/add-product" class="btn">Add Product</a>
</body>
</html>
