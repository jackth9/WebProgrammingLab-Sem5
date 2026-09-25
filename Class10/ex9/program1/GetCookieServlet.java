import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Read cookies from request
        Cookie[] cookies = request.getCookies();

        out.println("<html><body>");
        out.println("<h2>Stored Cookie Information</h2>");

        if (cookies != null && cookies.length > 0) {
            out.println("<table border='1'><tr><th>Cookie Name</th><th>Cookie Value</th></tr>");
            for (Cookie cookie : cookies) {
                out.println("<tr><td>" + cookie.getName() + "</td><td>" + cookie.getValue() + "</td></tr>");
            }
            out.println("</table>");
        } else {
            out.println("<p>No cookies found.</p>");
        }

        out.println("<br><a href='cookieForm.html'>Back to Form</a>");
        out.println("</body></html>");
    }
}