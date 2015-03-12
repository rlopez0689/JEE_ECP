package es.upm.miw.web.controllers.ejbs;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import es.upm.miw.web.controllers.AddThemeController;
import es.upm.miw.web.controllers.ControllerFactory;
import es.upm.miw.web.controllers.DeleteThemeController;
import es.upm.miw.web.controllers.SeeVotesController;
import es.upm.miw.web.controllers.VoteController;

@ManagedBean(name = "controllerFactory")
@ApplicationScoped
public class ControllerFactoryEJB extends ControllerFactory {
	
	private AddThemeController addThemeController;
	private DeleteThemeController deleteThemeController;
	private VoteController voteController;
	private SeeVotesController seeVotesController;
	
	@Override
	public AddThemeController getAddThemeController() {
		System.out.println("Regresar factoria");
		if(addThemeController == null){
			addThemeController = new AddThemeControllerEJB();
		}
		return this.addThemeController;
	}

	@Override
	public DeleteThemeController getDeleteThemeController() {
		if(deleteThemeController == null){
			deleteThemeController = new DeleteThemeController();
		}
		return this.deleteThemeController;
	}

	@Override
	public SeeVotesController getSeeVotesController() {
		if(seeVotesController == null){
			seeVotesController = new SeeVotesController();
		}
		return this.seeVotesController;
	}

	@Override
	public VoteController getVoteController() {
		if(voteController == null){
			voteController = new VoteController();
		}
		return this.voteController;
	}

}
