package es.upm.miw.web.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.web.controllers.ejbs.ControllerFactoryEJB;


@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String PATH_ROOT_VIEW = "/votesJSP/";
    
    private ControllerFactoryEJB cfEJB;
    
    public ControllerFactoryEJB getControllerFactoryEJB(){
    	if(cfEJB == null)
    		cfEJB = new ControllerFactoryEJB();
    	return cfEJB;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getPathInfo().substring(1);
        String view;
        switch (action) {
        case "addTheme":
            AddView addThemesView = new AddView();
            addThemesView.setTheme(new Theme());
            request.setAttribute(action, addThemesView);
            view = action;
            break;    
        case "authorizeThemes":
        	AuthorizeView authorizeView = new AuthorizeView();
            authorizeView.setControllerFactory(this.getControllerFactoryEJB());
            request.setAttribute(action, authorizeView);
            view = action;
            break;    
        case "voteTheme":
        	ListView listView = new ListView();
    		listView.setControllerFactory(this.getControllerFactoryEJB());
    		request.setAttribute("listThemes", listView);
    		view = "listThemes";
    		break;
        default:
            view = "home";
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo().substring(1);
        String view = "home";
        switch (action) {
        case "addTheme":
        	Theme theme = new Theme();
        	theme.setName(request.getParameter("name"));
        	theme.setQuestion(request.getParameter("question"));
        	AddView addThemesView = new AddView();
        	addThemesView.setControllerFactory(this.getControllerFactoryEJB());
        	addThemesView.setTheme(theme);
        	request.setAttribute(action, addThemesView);
        	view = addThemesView.process();
            break;
        case "verifyCode":
        	AuthorizeView authorizeView = new AuthorizeView();
        	authorizeView.setControllerFactory(this.getControllerFactoryEJB());
        	System.out.println(request.getParameter("code"));
        	authorizeView.setCode(request.getParameter("code"));
        	view = authorizeView.authorize();
        	if(authorizeView.isAuthorized()){
        		ListView listView = new ListView();
        		listView.setControllerFactory(this.getControllerFactoryEJB());
        		request.setAttribute("listThemes", listView);
        	}
        	break;
        case "deleteThemes":
        	DeleteView deleteView = new DeleteView();
        	deleteView.setControllerFactory(this.getControllerFactoryEJB());
        	deleteView.deleteTheme(request.getParameter("id"));
        	request.setAttribute("deleteThemes", deleteView);
        	view = "listThemes";
        	ListView listView = new ListView();
    		listView.setControllerFactory(this.getControllerFactoryEJB());
    		request.setAttribute("listThemes", listView);
            break;     
       }
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
        .forward(request, response);
   }
}