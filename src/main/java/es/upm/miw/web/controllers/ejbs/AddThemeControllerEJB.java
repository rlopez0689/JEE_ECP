package es.upm.miw.web.controllers.ejbs;

import es.upm.miw.persistence.models.daos.DaoFactory;
import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.web.controllers.AddThemeController;

public class AddThemeControllerEJB implements AddThemeController {

	public boolean addTheme(Theme theme) {
        DaoFactory.getFactory().getThemeDao().create(theme);
        return true;
	}

}
