package es.upm.miw.web.controllers.ejbs;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.persistence.models.daos.DaoFactory;
import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.persistence.models.utils.ThemeValoration;
import es.upm.miw.web.controllers.SeeVotesController;

public class SeeVotesControllerEJB implements SeeVotesController {

	@Override
	public List<ThemeValoration> getEducationVotes() {
		List<ThemeValoration> selectedVotesList = new ArrayList<ThemeValoration>();
		List<Theme> themes = new ArrayList<Theme>();
		themes = DaoFactory.getFactory().getThemeDao().findAll();
		for(int i=0; i<themes.size(); i++){
			ThemeValoration selectedVote = new ThemeValoration();
			selectedVote.setEducationAverageList(DaoFactory.getFactory().getVoteDao().getAverageVotesByEducationLevel(themes.get(i)));
			selectedVote.setValoration(DaoFactory.getFactory().getVoteDao().getNumberOfVotes(themes.get(i)));
			selectedVote.setTheme(themes.get(i));
			selectedVotesList.add(selectedVote);
		}	
		return selectedVotesList;
	}

}
