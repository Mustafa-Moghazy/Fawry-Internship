package org.eclipse.jakarta.hello;

import org.eclipse.jakarta.hello.dao.ProductDao;
import org.eclipse.jakarta.hello.dao.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/addProduct.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get form data
        String name = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("productPrice"));

        ProductDao productDao = new ProductDaoImpl();
        // Add the product to the repository
        productDao.addProduct(name, price);
        // Redirect to the products page
        response.sendRedirect(request.getContextPath() + "/products");
    }
}
