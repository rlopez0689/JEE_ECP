package es.upm.miw.models.daos.jpa;

import es.upm.miw.models.daos.ThemeDao;
import es.upm.miw.models.entities.Theme;

public class ThemeDaoJpa extends GenericDaoJpa<Theme, Integer> implements ThemeDao {

	public ThemeDaoJpa() {
        super(Theme.class);
    }

}
