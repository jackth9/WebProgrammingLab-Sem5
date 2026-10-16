import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SportsRegistrationServlet")
public class SportsRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Read input parameters
        String studentName = request.getParameter("studentName");
        String rollNumber = request.getParameter("rollNumber");
        String department = request.getParameter("department");
        String sportsEvent = request.getParameter("sportsEvent");
        String contactNumber = request.getParameter("contactNumber");

        // 2. Validate empty fields
        if (studentName == null || studentName.trim().isEmpty() ||
            rollNumber == null || rollNumber.trim().isEmpty() ||
            department == null || department.trim().isEmpty() ||
            sportsEvent == null || sportsEvent.trim().isEmpty() ||
            contactNumber == null || contactNumber.trim().isEmpty()) {
            response.sendRedirect("error.jsp?msg=All+fields+are+mandatory.");
            return;
        }

        studentName = studentName.trim();
        rollNumber = rollNumber.trim();
        department = department.trim();
        sportsEvent = sportsEvent.trim();
        contactNumber = contactNumber.trim();

        // 3. Ensure numeric values for Roll Number and Contact Number
        if (!rollNumber.matches("\\d+")) {
            response.sendRedirect("error.jsp?msg=Roll+Number+must+contain+only+numeric+digits.");
            return;
        }

        if (!contactNumber.matches("\\d{7,15}")) {
            response.sendRedirect("error.jsp?msg=Contact+Number+must+contain+numeric+digits+only+(7-15+digits).");
            return;
        }

        // 4. Insert into database using JDBC
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO sports_registration (student_name, roll_number, department, sports_event, contact_number) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, studentName);
                ps.setString(2, rollNumber);
                ps.setString(3, department);
                ps.setString(4, sportsEvent);
                ps.setString(5, contactNumber);

                int rowsInserted = ps.executeUpdate();
                if (rowsInserted > 0) {
                    response.sendRedirect("success.jsp");
                } else {
                    response.sendRedirect("error.jsp?msg=Database+insertion+failed.+Please+try+again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?msg=Database+Error:+" + java.net.URLEncoder.encode(e.getMessage() != null ? e.getMessage() : "Unknown error", "UTF-8"));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("sportsRegistration.jsp");
    }
}
