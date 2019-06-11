import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


    @WebServlet(urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        out.println("<ol><li>Username: " + req.getParameter("username") + "</li><li>Password: " + req.getParameter("password") + "</li><li>Age: " + req.getParameter("age") +"</li></ol>");

    }

        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            doGet(request, response);
        }
}
