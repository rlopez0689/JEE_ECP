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
import es.upm.miw.persistence.models.utils.ThemeEducationAverage;

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
		vote_data = new ArrayList<Vote>();
		Theme theme1 = new Theme("�Quien es el mejor deportista?", "Deportes");
		Theme theme2 = new Theme("�Quien es el mejor musico?", "Musica");
		Theme theme3 = new Theme("�Preguntas de deportes?", "Deportes");
		daoTheme.create(theme1);
		daoTheme.create(theme2);
		daoTheme.create(theme3);
		vote_data.add(new Vote(EducationLevel.MASTERSDEGREE, "127.0.0.1",1, theme1));
		vote_data.add(new Vote(EducationLevel.BACHELORDEGREE, "255.0.0.1",3, theme2));
		vote_data.add(new Vote(EducationLevel.DOCTORALDEGREE, "255.255.255.5",9, theme3));
		vote_data.add(new Vote(EducationLevel.BACHELORDEGREE, "255.255.255.5",4, theme1));
		for(int i=0;i<vote_data.size();i++){
			daoVote.create(vote_data.get(i));	
		}
	}
	
	@After
	public void cleanTables(){
		for(int i=0;i<vote_data.size();i++){
			daoVote.deleteVotesByTheme(vote_data.get(i).getTema().getId());
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
		List<Vote> votes_compare = new ArrayList<Vote>();
		for(int i=0;i<vote_data.size();i++){
			votes_compare.add(daoVote.read(vote_data.get(i).getId()));
		}
		
		List<Vote> votes = daoVote.findAll();
        for (Vote vote : votes_compare) {
            assertTrue(votes.contains(vote));
        }
	}

	@Test
	public void testUpdate() {
		String ip="255.127.34.2";
		EducationLevel ed = EducationLevel.MIDDLESCHOOL;
		Vote update_value = vote_data.get(0);
		update_value.setIp(ip);
		update_value.setNivel_estudios(ed);
		daoVote.update(update_value);		
		Vote updated_value = daoVote.read(update_value.getId());
		assertEquals(updated_value.getIp(), ip);
		assertEquals(updated_value.getNivel_estudios(), ed);
	}
	
	@Test
	public void TestGetNumberOfVotes(){
		Integer numberVotes = daoVote.getNumberOfVotes(vote_data.get(0).getTema());
		assertEquals(numberVotes.intValue(), 2);
	}
	
	@Test
	public void TestDeleteVotesByTheme(){
		Integer numberVotes = daoVote.getNumberOfVotes(vote_data.get(0).getTema());
		assertEquals(numberVotes.intValue(), 2);
		
		daoVote.deleteVotesByTheme(vote_data.get(0).getTema().getId());
		
		numberVotes = daoVote.getNumberOfVotes(vote_data.get(0).getTema());
		assertEquals(numberVotes.intValue(), 0);		
	}
	
	@Test
	public void getAverageVotesByEducationLevel(){
		List<ThemeEducationAverage> listEducation = daoVote.getAverageVotesByEducationLevel(vote_data.get(0).getTema());
		for(ThemeEducationAverage edAv: listEducation){
			if(edAv.getEd().equals(EducationLevel.MASTERSDEGREE))
				assertEquals(edAv.getAverage(), 1.0, 1e-15);
			else if(edAv.getEd().equals(EducationLevel.BACHELORDEGREE))
				assertEquals(edAv.getAverage(), 4.0, 1e-15);
			else
				assertEquals(edAv.getAverage(), 0.0, 1e-15);
		}
	}
}
