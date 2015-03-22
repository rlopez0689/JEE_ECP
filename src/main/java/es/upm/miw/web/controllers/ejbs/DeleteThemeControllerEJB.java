package es.upm.miw.web.controllers.ejbs;

import es.upm.miw.persistence.models.daos.DaoFactory;
import es.upm.miw.web.controllers.DeleteThemeController;

public class DeleteThemeControllerEJB extends ThemeControllerEJB implements DeleteThemeController  {

	@Override
	public boolean deleteTheme(Integer id) {
		DaoFactory.getFactory().getVoteDao().deleteVotesByTheme(id);
		DaoFactory.getFactory().getThemeDao().deleteById(id);
		return false;
	}

	@Override
	public boolean authorizeDelete(String code) {
		return code.equals("666");
	}

	@Override
	public boolean deleteTema(String code, int idTheme) {
		return false;
	}

}
