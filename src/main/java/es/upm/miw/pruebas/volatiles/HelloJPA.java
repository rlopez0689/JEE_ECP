package es.upm.miw.pruebas.volatiles;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.persistence.models.entities.Vote;
import es.upm.miw.persistence.models.utils.EducationLevel;

public class HelloJPA {
    public static void main(String[] args) {
        //Se borrar y se crean las tablas
        Map<String, String> properties = new HashMap<>();
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.DROP_AND_CREATE);
        EntityManager em = Persistence.createEntityManagerFactory("JEE_ECP", properties)
                .createEntityManager();
        
        Theme u1 = new Theme("ÀQuien es el mejor deportista?", "Deportes");
        Theme u2 = new Theme("ÀQuien es el mejor musico?", "Musica");
        Theme u3 = new Theme("ÀCual es el mejor videojuego de este a–o?", "Videjuegos");
        
        Vote v1 = new Vote(EducationLevel.MASTERSDEGREE, "127.0.0.1", u1);        
        Vote v2 = new Vote(EducationLevel.MASTERSDEGREE, "127.0.0.1", u2);
        Vote v3 = new Vote(EducationLevel.MASTERSDEGREE, "127.0.0.1", u3);
        // Create
        em.getTransaction().begin();
        em.persist(u1);
        em.persist(u2);
        em.persist(u3);
        em.persist(v1);
        em.persist(v2);
        em.persist(v3);
        em.persist(new Theme("ÀPreguntas de deportes?", "Deportes"));
        em.persist(new Theme("ÀPregunta de musica?", "Musica"));
        em.getTransaction().commit();
        // Read
        System.out.println(em.find(Theme.class, 1));
        /*
        // Update
        em.getTransaction().begin();
        em.merge(new Theme(2,"ÀPreguntas de tecnologia?", "dos cambiado con update"));
        em.getTransaction().commit();
        // Update2
        em.getTransaction().begin();
        u1.setName("uno, cambiado con set");
        em.getTransaction().commit();
        
        // Delete
        Theme u3 = em.find(Theme.class, 3);
        em.getTransaction().begin();
        em.remove(u3);
        em.getTransaction().commit();
        */
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.DROP_AND_CREATE);
    }
}