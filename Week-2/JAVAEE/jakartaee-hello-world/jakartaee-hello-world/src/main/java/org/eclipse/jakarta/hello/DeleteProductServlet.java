package org.eclipse.jakarta.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.eclipse.jakarta.hello.ProductServlet.productRepository;

@WebServlet("/delete-product")
public class DeleteProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the product ID from the query parameter
        String productId = request.getParameter("productId");
        productRepository.deleteProduct(Integer.parseInt(productId));
        // Redirect to the products page after deletion
        response.sendRedirect(request.getContextPath() + "/products");
    }
}
