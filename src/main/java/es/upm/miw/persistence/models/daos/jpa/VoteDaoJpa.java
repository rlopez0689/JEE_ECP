package es.upm.miw.persistence.models.daos.jpa;

import es.upm.miw.persistence.models.daos.VoteDao;
import es.upm.miw.persistence.models.entities.Vote;

public class VoteDaoJpa extends GenericDaoJpa<Vote, Integer> implements VoteDao {

	public VoteDaoJpa() {
        super(Vote.class);
    }

}
