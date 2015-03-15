package es.upm.miw.web.controllers.ejbs;

import es.upm.miw.persistence.models.daos.DaoFactory;
import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.persistence.models.entities.Vote;
import es.upm.miw.web.controllers.VoteController;

public class VoteControllerEJB implements VoteController {
	
	public Theme getTheme(Integer id) {
        return DaoFactory.getFactory().getThemeDao().read(id);
	}
	
	public boolean voteTheme(Vote vote){
		System.out.println("------------");
		System.out.println(vote);
		DaoFactory.getFactory().getVoteDao().create(vote);
		return true;
	}
}
