package my.servlets;

import my.dal.Product;
import my.dal.Repository;
import my.dal.RepositoryJDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="products", urlPatterns = {"/products"})
public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Repository repository = new RepositoryJDBC();
        List<Product> products = repository.getAllProducts();
        final PrintWriter out = resp.getWriter();
        out.println("<h1>Product list</h1>");
        products.forEach(p -> {
            out.println(p.getName() + " - " + p.getPrice() + "<br />");
        });

    }
}
