import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetCookieServlet")
public class SetCookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("personName");
        String code = request.getParameter("secretCode");

        // Create cookies
        Cookie nameCookie = new Cookie("personName", name);
        Cookie codeCookie = new Cookie("secretCode", code);

        // Set max age (e.g., 24 hours)
        nameCookie.setMaxAge(60 * 60 * 24);
        codeCookie.setMaxAge(60 * 60 * 24);

        // Add cookies to response header
        response.addCookie(nameCookie);
        response.addCookie(codeCookie);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Cookies have been successfully stored on the client!</h3>");
        out.println("<a href='GetCookieServlet'>Click here to retrieve cookies</a>");
        out.println("</body></html>");
    }
}