package org.eclipse.jakarta.hello;

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
        Product product = ProductRepository.findProductByID(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/WEB-INF/updateProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt((req.getParameter("productId")));
        String newName = req.getParameter("newName");
        double newPrice = Double.parseDouble(req.getParameter("newPrice"));
        Product product = ProductRepository.findProductByID(id);
        product.setName(newName);
        product.setPrice(newPrice);
        resp.sendRedirect(req.getContextPath() + "/products");
    }
}
