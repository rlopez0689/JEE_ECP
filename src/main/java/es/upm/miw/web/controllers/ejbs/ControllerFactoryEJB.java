package es.upm.miw.web.controllers.ejbs;

import javax.faces.bean.ManagedBean;

import es.upm.miw.web.controllers.AddThemeController;
import es.upm.miw.web.controllers.ControllerFactory;
import es.upm.miw.web.controllers.DeleteThemeController;
import es.upm.miw.web.controllers.SeeVotesController;
import es.upm.miw.web.controllers.VoteController;

@ManagedBean(name = "controllerFactory")
public class ControllerFactoryEJB extends ControllerFactory {
	
	private AddThemeController addThemeController;
	private DeleteThemeController deleteThemeController;
	private VoteController voteController;
	private SeeVotesController seeVotesController;
	
	public ControllerFactoryEJB(){
		this.addThemeController = new AddThemeControllerEJB();
		this.deleteThemeController = new DeleteThemeControllerEJB();
		this.voteController = new VoteControllerEJB();
		this.seeVotesController = new SeeVotesControllerEJB();
		
	}

	@Override
	public AddThemeController getAddThemeController() {
		return this.addThemeController;
	}

	@Override
	public DeleteThemeController getDeleteThemeController() {
		return this.deleteThemeController;
	}

	@Override
	public SeeVotesController getSeeVotesController() {
		return this.seeVotesController;
	}

	@Override
	public VoteController getVoteController() {
		return this.voteController;
	}

}
