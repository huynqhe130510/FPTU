
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author huyNguyen
 */
@WebServlet(urlPatterns = "/computer/do")
public class Calculator extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int A = Integer.parseInt(req.getParameter("A"));
        int B = Integer.parseInt(req.getParameter("B"));
        String operation = req.getParameter("operation");

        int result = 0;

        if (operation.equalsIgnoreCase("add")) {
            result = A + B;
        }
        if (operation.equalsIgnoreCase("sub")) {
            result = A - B;
        }
        if (operation.equalsIgnoreCase("mul")) {
            result = A * B;
        }
        if (operation.equalsIgnoreCase("div")) {
            result = A / B;
        }

        Random rd = new Random();
        int r = rd.nextInt(255);
        int g = rd.nextInt(255);
        int b = rd.nextInt(255);

        resp.getWriter().println("<html>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<h1>Result: <span style =' color: rgb(" + r + ", " + g + ", " + b + ");'> " + result + "</span></h1>");
        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
