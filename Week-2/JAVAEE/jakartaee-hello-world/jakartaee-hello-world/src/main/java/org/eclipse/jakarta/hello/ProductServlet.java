package org.eclipse.jakarta.hello;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    public static ProductRepository productRepository = new ProductRepository();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products = productRepository.findProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/product.jsp").forward(request, response);
    }
}

