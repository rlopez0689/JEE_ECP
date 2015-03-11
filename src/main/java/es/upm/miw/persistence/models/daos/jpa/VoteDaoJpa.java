package es.upm.miw.persistence.models.daos.jpa;


import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import es.upm.miw.persistence.models.daos.VoteDao;
import es.upm.miw.persistence.models.entities.Vote;

public class VoteDaoJpa extends GenericDaoJpa<Vote, Integer> implements VoteDao {

	public VoteDaoJpa() {
        super(Vote.class);
    }
	
	public void deleteVotesByTheme(Integer id){
		    EntityManager em = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
		    em.getTransaction().begin();
		    CriteriaBuilder cb = em.getCriteriaBuilder();		    
		    CriteriaDelete<Vote> delete = cb.createCriteriaDelete(Vote.class);
		    Root<Vote> e = delete.from(Vote.class);
		    delete.where(cb.equal(e.get("theme").get("id"), id));
		    em.createQuery(delete).executeUpdate();
		    em.getTransaction().commit();
	}
}
