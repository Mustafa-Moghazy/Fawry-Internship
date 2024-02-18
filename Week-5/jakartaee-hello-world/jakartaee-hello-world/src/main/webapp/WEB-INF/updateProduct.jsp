<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.eclipse.jakarta.hello.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<html>
<head>
    <title>Update Product</title>
    <!-- Add your CSS styles or include a separate CSS file here -->
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

        .form-container {
            width: 300px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ddd;
            border-radius: 3px;
        }

        button {
            padding: 10px;
            background-color: #4caf50;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Update Product</h1>

    <% Product product = (Product) request.getAttribute("product"); %>

    <div class="form-container">
        <form action="<%= request.getContextPath() %>/update-product" method="post">

            <div class="form-group">
                <label for="productId">Product ID:</label>
                <input type="text" id="productId" name="productId" value="<%= product.getId() %>" required>
            </div>

            <div class="form-group">
                <label for="newName">Product Name:</label>
                <input type="text" id="newName" name="newName" value="<%= product.getName() %>" required>
            </div>

            <div class="form-group">
                <label for="newPrice">Product Price:</label>
                <input type="text" id="newPrice" name="newPrice" value="<%= product.getPrice() %>" required>
            </div>

            <button type="submit">Update Product</button>
        </form>
    </div>
</body>
</html>
