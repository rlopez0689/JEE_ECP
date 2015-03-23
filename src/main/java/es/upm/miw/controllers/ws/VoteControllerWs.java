package es.upm.miw.controllers.ws;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.persistence.models.entities.Vote;
import es.upm.miw.web.controllers.VoteController;
import es.upm.miw.ws.VoteUris;

public class VoteControllerWs extends ControllerWs implements VoteController {

	@Override
	public Theme getTheme(Integer id) {
		return null;
	}

	@Override
	public boolean voteTheme(Vote vote) {
		return ControllerWs.buildWebServiceManager(VoteUris.PATH_VOTAR).create(vote);
	}

}
