package ru.senkin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


//http://localhost:8080/HomeWorkApp/show_products

@WebServlet(name = "Products", urlPatterns = "/show_products")
public class  ProductServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.debug("Log: Product");

        resp.setContentType("text/html");

        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Milk", 10));
        products.add(new Product(2, "Bread", 5));
        products.add(new Product(3, "Eggs", 30));
        products.add(new Product(4, "Meat", 100));
        products.add(new Product(5, "Orange", 10));
        products.add(new Product(6, "Bear", 50));
        products.add(new Product(7, "Potato", 15));
        products.add(new Product(8, "Tomato", 15));
        products.add(new Product(9, "Lemon", 15));
        products.add(new Product(10, "Ketchup", 20));
        products.add(new Product(11, "Pizza", 120));

        PrintWriter out = resp.getWriter();
        out.printf("<html><body>");
        for (Product product : products) {
            out.printf("<h1> " + product.toString() + "</h1>");
        }
        out.printf("</body></html>");
        out.close();

    }
}