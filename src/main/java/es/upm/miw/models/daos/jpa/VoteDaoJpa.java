package es.upm.miw.models.daos.jpa;

import es.upm.miw.models.daos.VoteDao;
import es.upm.miw.models.entities.Vote;

public class VoteDaoJpa extends GenericDaoJpa<Vote, Integer> implements VoteDao {

	public VoteDaoJpa() {
        super(Vote.class);
    }

}
