<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <style>
        body {
            text-align: center;
            display: flex;
            align-items:center;
            justify-content: center;
            flex-direction: column;
        }

        form {
            width: 300px; /* Adjust the width as needed */
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Login Page</h1>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="user">Username:</label>
        <input type="text" name="user" id="user" required><br>

        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required><br>

        <input type="submit" value="Login">
    </form>
</body>
</html>
