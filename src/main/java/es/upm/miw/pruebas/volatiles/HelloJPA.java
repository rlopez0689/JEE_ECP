package es.upm.miw.pruebas.volatiles;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;

import es.upm.miw.models.entities.Theme;

public class HelloJPA {
    public static void main(String[] args) {
        //Se borrar y se crean las tablas
        Map<String, String> properties = new HashMap<>();
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.DROP_AND_CREATE);
        EntityManager em = Persistence.createEntityManagerFactory("JEE_ECP", properties)
                .createEntityManager();
        
        Theme u1 = new Theme(1,"ÀEsta es una pregunta?", "Tema de prueba");
        // Create
        em.getTransaction().begin();
        em.persist(u1);
        em.persist(new Theme(2,"ÀPreguntas de deportes?", "Deportes"));
        em.persist(new Theme(3, "ÀPregunta de musica?", "Musica"));
        em.getTransaction().commit();
        // Read
        System.out.println(em.find(Theme.class, 1));
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
    }
}
