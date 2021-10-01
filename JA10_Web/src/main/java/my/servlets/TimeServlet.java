package my.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

// Idea CE не умеет работать с вебными проектами.
// Поэтому построение проекта возложено здесь на Maven (см. pom.xml)
// Чтобы Идея использовала чисто мавеновский,
// а не свой встроенный поcтроитель, нужно зайти
// File-Settings-<Build,Execution...>-<Build Tools>-Maven-Runner
// и поставить опцию <Delegate IDE Build/Run actions to Maven>.
// (Или использовать mvn package из окна Maven)

// NB. Чтобы аннотация сервлета сработала, в web.xml
// не должно быть атрибута metadata-complete="true":

@WebServlet(name="time", urlPatterns = {"/time"})
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "Current time is " + (new Date()).toString();
        resp.getWriter().println(message);
    }
}
