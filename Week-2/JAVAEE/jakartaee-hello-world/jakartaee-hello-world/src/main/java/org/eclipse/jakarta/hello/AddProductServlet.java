package org.eclipse.jakarta.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.eclipse.jakarta.hello.ProductServlet.productRepository;

@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {
//    static ProductRepository productRepository = new ProductRepository();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/addProduct.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get form data
        String name = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("productPrice"));
        // Create a new product
        int tempID = 0;
        Product newProduct = new Product(++tempID,name, price);
        // Add the product to the repository
        productRepository.addProduct(newProduct);
        // Redirect to the products page
        response.sendRedirect(request.getContextPath() + "/products");
    }
}
