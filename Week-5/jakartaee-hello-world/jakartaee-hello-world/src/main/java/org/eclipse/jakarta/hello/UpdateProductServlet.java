package org.eclipse.jakarta.hello;

import org.eclipse.jakarta.hello.dao.ProductDao;
import org.eclipse.jakarta.hello.dao.ProductDaoImpl;
import org.eclipse.jakarta.hello.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/update-product")
public class UpdateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        ProductDao productDao = new ProductDaoImpl();
        Product product = productDao.findById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/WEB-INF/updateProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt((req.getParameter("productId")));
        String newName = req.getParameter("newName");
        double newPrice = Double.parseDouble(req.getParameter("newPrice"));
        ProductDao productDao = new ProductDaoImpl();
        productDao.updateProduct(id, newName, newPrice);
        resp.sendRedirect(req.getContextPath() + "/products");
    }
}
