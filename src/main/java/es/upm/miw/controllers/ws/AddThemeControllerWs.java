package es.upm.miw.controllers.ws;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.web.controllers.AddThemeController;
import es.upm.miw.ws.ThemeUris;

public class AddThemeControllerWs extends ControllerWs implements AddThemeController {

	@Override
	public boolean addTheme(Theme theme) {
		return ControllerWs.buildWebServiceManager(ThemeUris.PATH_THEMES).create(theme);
	}
	
}
