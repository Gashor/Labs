import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculatorServlet extends HttpServlet {
    private static final String X = "x";
    private static final String Y = "y";
    private static final String OPERATION = "operation";
    private static final String RESULT = "result";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter(X).replace(',', '.');
        String y = req.getParameter(Y).replace(',', '.');
        String operation = req.getParameter(OPERATION);

        CalculatorService service = new CalculatorService();

        String result = service.calculate(x, y, operation);

        req.setAttribute(X, x);
        req.setAttribute(Y, y);
        req.setAttribute(OPERATION, operation);
        req.setAttribute(RESULT, result);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}
