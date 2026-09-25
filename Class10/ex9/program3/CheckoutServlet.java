import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("customerName");
        String email = request.getParameter("customerEmail");
        double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO orders (customer_name, customer_email, total_amount) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDouble(3, totalAmount);

            int rows = ps.executeUpdate();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            if (rows > 0) {
                // Clear the session cart
                HttpSession session = request.getSession(false);
                if (session != null) {
                    session.removeAttribute("cart");
                }

                out.println("<html><body>");
                out.println("<h2>Thank You! Your order has been placed successfully.</h2>");
                out.println("<p>Customer Name: " + name + "</p>");
                out.println("<p>Email: " + email + "</p>");
                out.println("<p>Total Amount Paid: $" + totalAmount + "</p>");
                out.println("<a href='CatalogServlet'>Back to Products</a>");
                out.println("</body></html>");
            } else {
                out.println("<h3>Order Placement Failed. Please try again.</h3>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}