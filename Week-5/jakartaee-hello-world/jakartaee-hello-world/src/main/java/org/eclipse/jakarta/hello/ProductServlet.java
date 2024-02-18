package org.eclipse.jakarta.hello;

import org.eclipse.jakarta.hello.dao.ProductDao;
import org.eclipse.jakarta.hello.dao.ProductDaoImpl;
import org.eclipse.jakarta.hello.entity.Product;
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
    private ProductDao productDao;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         productDao = new ProductDaoImpl();
        List<Product> products = productDao.getProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/product.jsp").forward(request, response);
    }
}

