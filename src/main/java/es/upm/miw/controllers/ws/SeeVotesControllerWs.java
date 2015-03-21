package es.upm.miw.controllers.ws;

import java.util.List;

import es.upm.miw.persistence.models.utils.ThemeValoration;
import es.upm.miw.web.controllers.SeeVotesController;
import es.upm.miw.ws.VoteUris;
import es.upm.miw.ws.utils.ThemeValorationWrapper;

public class SeeVotesControllerWs extends ControllerWs implements SeeVotesController {

	@Override
	public List<ThemeValoration> getEducationVotes() {
		WsManager wsManager = ControllerWs.buildWebServiceManager(VoteUris.PATH_VOTACIONES);
		if(wsManager.read()){
			return wsManager.entity(ThemeValorationWrapper.class).getlistThemeValoration();
		}
		return null;		
	}
}
