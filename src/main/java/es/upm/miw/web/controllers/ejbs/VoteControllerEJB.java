package es.upm.miw.web.controllers.ejbs;

import es.upm.miw.persistence.models.daos.DaoFactory;
import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.web.controllers.VoteController;

public class VoteControllerEJB extends ThemeControllerEJB implements VoteController {
	
	public Theme getTheme(Integer id) {
        return DaoFactory.getFactory().getThemeDao().read(id);
	}
}
