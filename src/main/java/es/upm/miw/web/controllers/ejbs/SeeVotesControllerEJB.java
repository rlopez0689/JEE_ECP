package es.upm.miw.web.controllers.ejbs;

import java.util.List;

import es.upm.miw.persistence.models.daos.DaoFactory;
import es.upm.miw.persistence.models.entities.Vote;
import es.upm.miw.web.controllers.SeeVotesController;

public class SeeVotesControllerEJB implements SeeVotesController {

	@Override
	public List<Object[]> getNormalVotes() {
		return DaoFactory.getFactory().getVoteDao().getNumberOfVotes();
	}

	@Override
	public List<Object[]> getEducationVotes() {
		return null;
	}

}
