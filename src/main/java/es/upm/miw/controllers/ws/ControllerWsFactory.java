package es.upm.miw.controllers.ws;

import es.upm.miw.web.controllers.AddThemeController;
import es.upm.miw.web.controllers.ControllerFactory;
import es.upm.miw.web.controllers.DeleteThemeController;
import es.upm.miw.web.controllers.SeeVotesController;
import es.upm.miw.web.controllers.ThemeController;
import es.upm.miw.web.controllers.VoteController;

public class ControllerWsFactory extends ControllerFactory {
	
	private SeeVotesController seeVotesController;
	
	@Override
	public AddThemeController getAddThemeController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteThemeController getDeleteThemeController() {
		// TODO Auto-generated method stub
		return null;
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
