package es.upm.miw.web.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/v1/*")
public class Dispatcher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String PATH_ROOT_VIEW = "/votesJSP/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getPathInfo().substring(1);

        String view;
        switch (action) {
        case "temas":
            SeeThemesView themesView = new SeeThemesView();
            //personaView.setPersona(new Persona());
            request.setAttribute(action, themesView);
            view = action;
            break;
        case "rol":
            SeeVotesView rolView = new SeeVotesView();
            request.setAttribute(action, rolView);
            view = action;
            break;
        default:
            view = "home";
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);

    }
}