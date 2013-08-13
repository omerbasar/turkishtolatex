package ob;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: obasar
 * Date: Apr 2, 2010
 * Time: 1:15:00 AM
 */
public class ConverterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("text", "");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String text = req.getParameter("text");

        if (text == null) {
            text = "";
        }

        req.setAttribute("text", text);
        req.setAttribute("output", turkishToLatex(text));

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);

    }

    public static String turkishToLatex(String text) {
        return text.replace("\u011E", "\\u{G}").
                replace("\u011F", "\\u{g}").
                replace("\u00DC", "\\\"U").
                replace("\u00FC", "\\\"u").
                replace("\u00C7", "\\c{C}").
                replace("\u00E7", "\\c{c}").
                replace("\u015E", "\\c{S}").
                replace("\u015F", "\\c{s}").
                replace("\u00D6", "\\\"O").
                replace("\u00F6", "\\\"o").
                replace("\u0131", "{\\i}").
                replace("\u0130", "\\.{I}").
                replace("\u00E2", "\\^{a}").
                replace("\u00FB", "\\^{u}").
                replace("\u00EE", "\\^{i}").
                replace("\u00C2", "\\^{A}").
                replace("\u00DB", "\\^{U}").
                replace("\u00CE", "\\^{I}").
                replace("%", "\\%");
    }
}
