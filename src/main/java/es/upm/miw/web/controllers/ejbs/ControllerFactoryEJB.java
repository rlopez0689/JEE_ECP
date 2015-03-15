package es.upm.miw.web.controllers.ejbs;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import es.upm.miw.web.controllers.AddThemeController;
import es.upm.miw.web.controllers.ControllerFactory;
import es.upm.miw.web.controllers.DeleteThemeController;
import es.upm.miw.web.controllers.SeeVotesController;
import es.upm.miw.web.controllers.ThemeController;
import es.upm.miw.web.controllers.VoteController;

@ManagedBean(name = "controllerFactory")
@ApplicationScoped
public class ControllerFactoryEJB extends ControllerFactory {
	
	private AddThemeController addThemeController;
	private DeleteThemeController deleteThemeController;
	private VoteController voteController;
	private SeeVotesController seeVotesController;
	private ThemeController themeController;
	
	@Override
	public AddThemeController getAddThemeController() {
		if(addThemeController == null)
			addThemeController = new AddThemeControllerEJB();
		return this.addThemeController;
	}

	@Override
	public DeleteThemeController getDeleteThemeController() {
		if(deleteThemeController == null)
			deleteThemeController = new DeleteThemeControllerEJB();
		return this.deleteThemeController;
	}

	@Override
	public SeeVotesController getSeeVotesController() {
		if(seeVotesController == null)
			seeVotesController = new SeeVotesController();
		return this.seeVotesController;
	}

	@Override
	public VoteController getVoteController() {
		if(voteController == null)
			voteController = new VoteControllerEJB();
		return this.voteController;
	}

	@Override
	public ThemeController getThemeController() {
		if(themeController == null)
			themeController = new ThemeControllerEJB();
		return this.themeController;
	}
}
