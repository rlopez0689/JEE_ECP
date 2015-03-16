package es.upm.miw.persistence.models.daos;

import java.util.List;

import es.upm.miw.persistence.models.entities.Vote;

public interface VoteDao extends GenericDao<Vote, Integer> {
	public void deleteVotesByTheme(Integer id);
	public List<Vote> getNumberOfVotesByTheme(Integer id);
	public List<Object[]> getAverageVotesByEducationLevel();
	public List<Object[]> getNumberOfVotes();
}
