import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
private int hits =0;


    protected void doGet(HttpServletRequest req, HttpServletResponse res) {

        String name = req.getParameter("name");

        String hitreset = req.getParameter("reset");
        if(hitreset == null){
            hits +=1;
        } else if (hitreset.toLowerCase().contains("y")){
            hits =1;
        } else {
            hits +=1;
        }
        String form = "<form method=\"POST\" target=\"/profile\" action=\"/profile\">\n" +
                "        <label class=\"form-label\" for=\"username\">Username<input  type=\"text\" id=\"username\" name=\"username\" placeholder=\"Enter Username\" autofocus=\"autofocus\" required></label><br>\n" +
                "        <label class=\"form-label\" for=\"password\">Password<input type=\"password\" placeholder=\"password\" id=\"password\" name=\"password\" required></label><br>\n" +
                "    <label for=\"age\">Age<input type=\"text\" name=\"age\" id=\"age\" placeholder=\"Enter age\"></label><button type=\"submit\">Login</button></form>";
        try {
            PrintWriter out = res.getWriter();
            if (name == null) {
                out.println("<h1>Hello World!</h1>");

                out.println(form);
            } else {
                out.println("<h1>Hello " + name + "!</h1>");
                out.println(form);
            }
                out.println("This page has been viewed " + hits + " times!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        doGet(request, response);
//    }
}
