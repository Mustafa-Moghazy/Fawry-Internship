package org.eclipse.jakarta.hello;

import org.eclipse.jakarta.hello.dao.ProductDao;
import org.eclipse.jakarta.hello.dao.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/delete-product")
public class DeleteProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the product ID from the query parameter
        String productId = request.getParameter("productId");
        ProductDao productDao = new ProductDaoImpl();
        productDao.deleteProduct(Integer.parseInt(productId));
        // Redirect to the products page after deletion
        response.sendRedirect(request.getContextPath() + "/products");
    }
}
