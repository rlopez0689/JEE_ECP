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
import es.upm.miw.persistence.models.entities.Theme;

public class ThemeDaoJpaTest {
	
	private ThemeDao dao = DaoJpaFactory.getFactory().getThemeDao();
	private static ArrayList<Theme> themes_data;
	private static EntityManager em;	
		
	@BeforeClass
	public static void createTables(){
		Map<String, String> properties = new HashMap<>();
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.CREATE_ONLY);
        em = Persistence.createEntityManagerFactory("JEE_ECP", properties)
                .createEntityManager();
        em.clear();
        
        themes_data = new ArrayList<Theme>();
		themes_data.add(new Theme("�Quien es el mejor deportista?", "Deportes"));
		themes_data.add(new Theme("�Quien es el mejor musico?", "Musica"));
		themes_data.add(new Theme("�Cual es el mejor videojuego de este a�o?", "Videjuegos"));
		themes_data.add(new Theme("�Preguntas de deportes?", "Deportes"));
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
		for(int i=0;i<themes_data.size();i++){
			dao.create(themes_data.get(i));
		}
	}
	
	@After
	public void cleanTables(){
		for(int i=0;i<themes_data.size();i++){
			dao.deleteById(themes_data.get(i).getId());
		}
	}

	@Test
	public void testCreate() {
		List<Theme> themes_compare = new ArrayList<Theme>();
		for(int i=0;i<themes_data.size();i++){
			themes_compare.add(themes_data.get(i));
		}
		
        List<Theme> themes = dao.findAll();
        for (Theme theme : themes_compare) {
            assertTrue(themes.contains(theme));
        }
        assertTrue(themes.size() == themes_compare.size());
	}

	@Test
	public void testRead() {		
		ArrayList<Integer> themes_ids = new ArrayList<Integer>();
		List<Theme> themes_compare = new ArrayList<Theme>();
		for(int i=0;i<themes_data.size();i++){
			themes_compare.add(themes_data.get(i));
			themes_ids.add(themes_data.get(i).getId());
		}
		
		for(int i=0;i<themes_ids.size();i++){
			assertEquals(themes_ids.get(i),themes_data.get(i).getId());
		}
	}

	@Test
	public void testUpdate() {
		for(int i=0;i<themes_data.size();i++){
			dao.update(themes_data.get(i));
		}
	}

}
