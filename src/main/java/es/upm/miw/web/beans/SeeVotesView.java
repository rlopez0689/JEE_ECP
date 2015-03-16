package es.upm.miw.web.beans;

import es.upm.miw.persistence.models.entities.Vote;
import es.upm.miw.web.controllers.SeeVotesController;

public class SeeVotesView extends ViewBean {
	
	private Vote[] normalVotes;
	private Vote[] educationVotes;
	
	public Vote[] getNormalVotes() {
		return normalVotes;
	}

	public void setNormalVotes(Vote[] normalVotes) {
		this.normalVotes = normalVotes;
	}

	public Vote[] getEducationVotes() {
		return educationVotes;
	}

	public void setEducationVotes(Vote[] educationVotes) {
		this.educationVotes = educationVotes;
	}
	
	public void procesar() {
		SeeVotesController voteController = this.getControllerFactory().getSeeVotesController();
	}
}
