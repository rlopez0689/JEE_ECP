package es.upm.miw.web.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.miw.persistence.models.utils.Utils;

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
        request.setCharacterEncoding("UTF-8");
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
        case "selectTheme":
        	SelectView selectView = new SelectView();
        	selectView.setControllerFactory(this.getControllerFactoryEJB());
    		request.setAttribute(action, selectView);
    		view = action;
    		break;
        case "voteTheme":
        	VoteView voteView = new VoteView();
        	voteView.setControllerFactory(this.getControllerFactoryEJB());
        	request.setAttribute(action, voteView);
        	voteView.setIdTema(Integer.parseInt(request.getParameter("id")));
        	voteView.assignTheme();
        	view = action;
        	break;
        case "seeVotes":
        	SeeVotesView seeVotesView = new SeeVotesView();
        	seeVotesView.setControllerFactory(this.getControllerFactoryEJB());
        	request.setAttribute(action, seeVotesView);
        	seeVotesView.procesar();
        	view = action;
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
        request.setCharacterEncoding("UTF-8");
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
        case "deleteTheme":
        	DeleteView deleteView = new DeleteView();
        	deleteView.setControllerFactory(this.getControllerFactoryEJB());
        	deleteView.deleteTheme(request.getParameter("id"));
        	request.setAttribute("deleteThemes", deleteView);
        	view = "listThemes";
        	ListView listView = new ListView();
    		listView.setControllerFactory(this.getControllerFactoryEJB());
    		request.setAttribute("listThemes", listView);
            break;  
        case "voteTheme":
        	VoteView voteView = new VoteView();
        	voteView.setControllerFactory(this.getControllerFactoryEJB());
        	voteView.setIdTema(Integer.parseInt(request.getParameter("id")));
        	voteView.setSelectedEd(request.getParameter("education_level"));
        	voteView.setSelectedVal(request.getParameter("valoration"));
        	voteView.setUsedIp(Utils.getIpAddress(request));
        	voteView.procesar();
        	SelectView selectView = new SelectView();
        	selectView.setControllerFactory(this.getControllerFactoryEJB());
    		request.setAttribute("selectTheme", selectView);
    		view = "selectTheme";
        	break;
       }
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
        .forward(request, response);
   }
    
}