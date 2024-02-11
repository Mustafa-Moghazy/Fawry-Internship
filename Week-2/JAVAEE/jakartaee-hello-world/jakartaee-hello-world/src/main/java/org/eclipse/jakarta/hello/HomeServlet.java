package org.eclipse.jakarta.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Home</title> </head>");
        out.println("<body style='text-align:center;'> <h1>Welcome To Our Home Page </h1></body> </html>");
        out.println("<h3><a href='" + req.getContextPath() + "/login'>Login</a> to view our products ^_^</h3>");

    }
}
