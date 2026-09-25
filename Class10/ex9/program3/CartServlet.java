import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            int id = Integer.parseInt(request.getParameter("productId"));
            String name = request.getParameter("productName");
            double price = Double.parseDouble(request.getParameter("productPrice"));

            if (cart.containsKey(id)) {
                CartItem item = cart.get(id);
                item.setQuantity(item.getQuantity() + 1);
            } else {
                cart.put(id, new CartItem(new Product(id, name, price), 1));
            }
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("productId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            if (quantity <= 0) {
                cart.remove(id);
            } else {
                cart.get(id).setQuantity(quantity);
            }
        } else if ("remove".equals(action)) {
            int id = Integer.parseInt(request.getParameter("productId"));
            cart.remove(id);
        }

        response.sendRedirect("CartServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

        out.println("<html><body>");
        out.println("<h2>Your Shopping Cart</h2>");

        if (cart == null || cart.isEmpty()) {
            out.println("<p>Your cart is empty.</p>");
        } else {
            out.println("<table border='1'><tr><th>Item</th><th>Price</th><th>Quantity</th><th>Total</th><th>Actions</th></tr>");
            double grandTotal = 0;

            for (CartItem item : cart.values()) {
                grandTotal += item.getTotalPrice();
                out.println("<tr>");
                out.println("<td>" + item.getProduct().getName() + "</td>");
                out.println("<td>$" + item.getProduct().getPrice() + "</td>");
                out.println("<td>");
                out.println("<form action='CartServlet' method='POST' style='display:inline;'>");
                out.println("<input type='hidden' name='productId' value='" + item.getProduct().getId() + "'>");
                out.println("<input type='hidden' name='action' value='update'>");
                out.println("<input type='number' name='quantity' value='" + item.getQuantity() + "' min='1'>");
                out.println("<input type='submit' value='Update'>");
                out.println("</form>");
                out.println("</td>");
                out.println("<td>$" + item.getTotalPrice() + "</td>");
                out.println("<td>");
                out.println("<form action='CartServlet' method='POST' style='display:inline;'>");
                out.println("<input type='hidden' name='productId' value='" + item.getProduct().getId() + "'>");
                out.println("<input type='hidden' name='action' value='remove'>");
                out.println("<input type='submit' value='Remove'>");
                out.println("</form>");
                out.println("</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("<h3>Grand Total: $" + grandTotal + "</h3>");

            out.println("<h3>Checkout</h3>");
            out.println("<form action='CheckoutServlet' method='POST'>");
            out.println("<label>Name:</label> <input type='text' name='customerName' required><br><br>");
            out.println("<label>Email:</label> <input type='email' name='customerEmail' required><br><br>");
            out.println("<input type='hidden' name='totalAmount' value='" + grandTotal + "'>");
            out.println("<input type='submit' value='Place Order'>");
            out.println("</form>");
        }

        out.println("<br><a href='CatalogServlet'>Continue Shopping</a>");
        out.println("</body></html>");
    }
}