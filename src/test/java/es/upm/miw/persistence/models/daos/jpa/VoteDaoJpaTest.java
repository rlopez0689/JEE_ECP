package es.upm.miw.persistence.models.daos.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.upm.miw.persistence.models.daos.ThemeDao;
import es.upm.miw.persistence.models.daos.VoteDao;
import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.persistence.models.entities.Vote;
import es.upm.miw.persistence.models.utils.EducationLevel;

public class VoteDaoJpaTest {
	
	private ThemeDao daoTheme = DaoJpaFactory.getFactory().getThemeDao();
	private VoteDao daoVote = DaoJpaFactory.getFactory().getVoteDao();
	private static ArrayList<Vote> vote_data;
	private static EntityManager em;
	
	@BeforeClass
	public static void createTables(){
		Map<String, String> properties = new HashMap<>();
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.CREATE_ONLY);
        em = Persistence.createEntityManagerFactory("JEE_ECP", properties)
                .createEntityManager();
        em.clear();
        vote_data = new ArrayList<Vote>();
		vote_data.add(new Vote(EducationLevel.MASTERSDEGREE, "127.0.0.1", new Theme("ÀQuien es el mejor deportista?", "Deportes")));
		vote_data.add(new Vote(EducationLevel.BACHELORDEGREE, "255.0.0.1", new Theme("ÀQuien es el mejor musico?", "Musica")));
		vote_data.add(new Vote(EducationLevel.DOCTORALDEGREE, "255.255.255.5", new Theme("ÀPreguntas de deportes?", "Deportes")));
	}
	
	@AfterClass
	public static void DropTables(){
        em.getTransaction().begin();
        em.createNativeQuery("drop table vote").executeUpdate();
        em.createNativeQuery("drop table theme").executeUpdate();
        em.getTransaction().commit();
	}
	
	@Before
	public void beforeTest(){
		for(int i=0;i<vote_data.size();i++){
			daoVote.create(vote_data.get(i));	
		}
	}
	
	@After
	public void cleanTables(){
		for(int i=0;i<vote_data.size();i++){
			daoVote.deleteById(vote_data.get(i).getId());
			daoTheme.deleteById(vote_data.get(i).getTema().getId());
		}
	}
		
	@Test
	public void testCreate() {
		List<Vote> votes_compare = new ArrayList<Vote>();
		for(int i=0;i<vote_data.size();i++){
			votes_compare.add(vote_data.get(i));
		}
		
        List<Vote> votes = daoVote.findAll();
        for (Vote vote : votes_compare) {
            assertTrue(votes.contains(vote));
        }
        assertTrue(votes.size() == votes_compare.size());
	}

	@Test
	public void testRead() {		
		ArrayList<Integer> votes_ids = new ArrayList<Integer>();
		List<Vote> votes_compare = new ArrayList<Vote>();
		for(int i=0;i<vote_data.size();i++){
			votes_compare.add(vote_data.get(i));
			votes_ids.add(vote_data.get(i).getId());
		}
		
		for(int i=0;i<votes_ids.size();i++){
			assertEquals(votes_ids.get(i),vote_data.get(i).getId());
		}
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}
}
