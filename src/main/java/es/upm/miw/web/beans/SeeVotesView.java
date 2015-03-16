package es.upm.miw.web.beans;

import java.util.List;

import es.upm.miw.persistence.models.utils.ThemeValoration;
import es.upm.miw.web.controllers.SeeVotesController;

public class SeeVotesView extends ViewBean {
	
	private List<ThemeValoration> groupVotes;
	
	public List<ThemeValoration> getgroupVotes() {
		return groupVotes;
	}

	public void setgroupVotes(List<ThemeValoration> groupVotes) {
		this.groupVotes = groupVotes;
	}
	
	public void procesar() {
		System.out.println("Procesar ver votos");
		SeeVotesController voteController = this.getControllerFactory().getSeeVotesController();
		this.setgroupVotes(voteController.getEducationVotes());
	}
}
