package es.upm.miw.controllers.ws;

import es.upm.miw.web.controllers.AddThemeController;
import es.upm.miw.web.controllers.ControllerFactory;
import es.upm.miw.web.controllers.DeleteThemeController;
import es.upm.miw.web.controllers.SeeVotesController;
import es.upm.miw.web.controllers.ThemeController;
import es.upm.miw.web.controllers.VoteController;

public class ControllerWsFactory extends ControllerFactory {
	
	private SeeVotesController seeVotesController;
	private AddThemeController addThemeController;
	private DeleteThemeController deleteThemeController;
	
	@Override
	public AddThemeController getAddThemeController() {
		if (addThemeController == null) {
			addThemeController = new AddThemeControllerWs();
        }
        return addThemeController;
	}

	@Override
	public DeleteThemeController getDeleteThemeController() {
		if (deleteThemeController == null) {
			deleteThemeController = new DeleteThemeControllerWs();
        }
        return deleteThemeController;
	}

	@Override
	public SeeVotesController getSeeVotesController() {
		if (seeVotesController == null) {
			seeVotesController = new SeeVotesControllerWs();
        }
        return seeVotesController;
	}

	@Override
	public VoteController getVoteController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ThemeController getThemeController() {
		// TODO Auto-generated method stub
		return null;
	}

}
