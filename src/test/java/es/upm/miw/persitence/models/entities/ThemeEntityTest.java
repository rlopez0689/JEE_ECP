package es.upm.miw.persitence.models.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import es.upm.miw.persistence.models.entities.Theme;

public class ThemeEntityTest {

	@Test
	public void testEquals() {
		Theme t1 = new Theme(5,"prueba", "prueba");
		Theme t2 = new Theme(5,"prueba", "prueba");
		Theme t3 = new Theme(3,"prueba2", "prueba3");		
		assertTrue(t1.equals(t2));
		assertFalse(t1.equals(t3));
	}

}
