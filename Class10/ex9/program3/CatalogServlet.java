import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<Product> products = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");

            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("<html><body>");
        out.println("<h2>Product Catalog</h2>");
        out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Price</th><th>Action</th></tr>");

        for (Product p : products) {
            out.println("<tr>");
            out.println("<td>" + p.getId() + "</td>");
            out.println("<td>" + p.getName() + "</td>");
            out.println("<td>$" + p.getPrice() + "</td>");
            out.println("<td><form action='CartServlet' method='POST'>" +
                    "<input type='hidden' name='productId' value='" + p.getId() + "'>" +
                    "<input type='hidden' name='productName' value='" + p.getName() + "'>" +
                    "<input type='hidden' name='productPrice' value='" + p.getPrice() + "'>" +
                    "<input type='hidden' name='action' value='add'>" +
                    "<input type='submit' value='Add to Cart'>" +
                    "</form></td>");
            out.println("</tr>");
        }

        out.println("</table><br>");
        out.println("<a href='CartServlet'>View Cart</a>");
        out.println("</body></html>");
    }
}