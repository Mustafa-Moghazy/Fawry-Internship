package org.eclipse.jakarta.hello;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // validation //
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        if ("admin".equals(user) && "admin".equals(password)) {
            response.sendRedirect(request.getContextPath() + "/products");
        } else {
            request.getRequestDispatcher("/WEB-INF/erorr.jsp").forward(request, response);
        }
    }
}
