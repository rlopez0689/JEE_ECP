package es.upm.miw.persistence.models.daos.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.upm.miw.persistence.models.daos.VoteDao;
import es.upm.miw.persistence.models.entities.Vote;

public class VoteDaoJpa extends GenericDaoJpa<Vote, Integer> implements VoteDao {

	public VoteDaoJpa() {
        super(Vote.class);
    }
	
	@Override
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

	@Override
	public List<Vote> getNumberOfVotesByTheme(Integer id) {
		EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Vote> criteriaQuery = criteriaBuilder.createQuery(Vote.class);
        Root<Vote> root = criteriaQuery.from(Vote.class);

        criteriaQuery.select(root); 
        Predicate predicate = criteriaBuilder.equal(root.get("theme").get("id"),id);
        criteriaQuery.where(predicate);
        TypedQuery<Vote> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(0); // El primero es 0
        typedQuery.setMaxResults(0); // Se realiza la query, se buscan todos
        List<Vote> result = typedQuery.getResultList();
        entityManager.close();
        return result;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAverageVotesByEducationLevel() {
		EntityManager em = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("SELECT avg((c.valoration)), c.education_level FROM Vote c WHERE c.theme.id=3852 group by c.education_level", Object[].class);
		List<Object[]> results = query.getResultList();
		return results;
	}
}
