package es.upm.miw.persistence.models.daos.jpa;


import es.upm.miw.persistence.models.daos.ThemeDao;
import es.upm.miw.persistence.models.entities.Theme;

public class ThemeDaoJpa extends GenericDaoJpa<Theme, Integer> implements ThemeDao {

	public ThemeDaoJpa() {
        super(Theme.class);
    }
}
