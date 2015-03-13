package es.upm.miw.web.controllers.ejbs;

import java.util.List;

import es.upm.miw.persistence.models.daos.DaoFactory;
import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.web.controllers.ThemeController;

public class ThemeControllerEJB implements ThemeController {

	@Override
	public List<Theme> getThemes() {
		System.out.println("Sacar temas");
        return DaoFactory.getFactory().getThemeDao().findAll();
	}

}
