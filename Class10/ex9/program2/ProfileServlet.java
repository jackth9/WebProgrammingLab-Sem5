import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("userName") != null) {
            String name = (String) session.getAttribute("userName");
            String email = (String) session.getAttribute("userEmail");

            out.println("<html><body>");
            out.println("<h2>Welcome to Your Profile, " + name + "!</h2>");
            out.println("<p><b>Email:</b> " + email + "</p>");
            out.println("<form action='LogoutServlet' method='POST'>");
            out.println("<input type='submit' value='Logout'>");
            out.println("</form>");
            out.println("</body></html>");
        } else {
            response.sendRedirect("login.html");
        }
    }
}