package es.upm.miw.persitence.models.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.persistence.models.entities.Vote;
import es.upm.miw.persistence.models.utils.EducationLevel;

public class VoteEntityTest {

	@Test
	public void testEquals() {
		Theme t1 = new Theme(5,"prueba", "prueba");
		Vote v1 = new Vote(5, "125.0.0.1", t1, 3, EducationLevel.ASSOCITEDEGREE);
		Vote v2 = new Vote(5, "125.0.0.1", t1, 3, EducationLevel.ASSOCITEDEGREE);
		Vote v3 = new Vote(6, "125.0.0.2", t1, 5, EducationLevel.DOCTORALDEGREE);	
		assertTrue(v1.equals(v2));
		assertFalse(v1.equals(v3));
	}

}
