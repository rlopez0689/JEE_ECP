package es.upm.miw.persistence.models.daos;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.persistence.models.entities.Vote;
import es.upm.miw.persistence.models.utils.ThemeEducationAverage;

public interface VoteDao extends GenericDao<Vote, Integer> {
	public void deleteVotesByTheme(Integer id);
	public List<Vote> getNumberOfVotesByTheme(Integer id);
	public ArrayList<ThemeEducationAverage> getAverageVotesByEducationLevel(Theme theme);
	public Integer getNumberOfVotes(Theme theme);
}
