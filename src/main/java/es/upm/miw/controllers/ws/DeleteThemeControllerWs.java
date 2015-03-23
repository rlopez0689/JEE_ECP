package es.upm.miw.controllers.ws;

import es.upm.miw.web.controllers.DeleteThemeController;
import es.upm.miw.ws.ThemeUris;

public class DeleteThemeControllerWs extends ControllerWs implements DeleteThemeController {

	@Override
	public boolean deleteTheme(Integer id) {
		return false;
	}

	@Override
	public boolean authorizeDelete(String code) {
		return false;
	}
	
	public boolean deleteTema(String code, int idTheme){
		WsManager wsManager = ControllerWs.buildWebServiceManager(ThemeUris.PATH_THEMES);
        wsManager.addPath(ThemeUris.PATH_ID);
        wsManager.addParams("code", code);
        Integer inte = new Integer(idTheme);
        wsManager.addObjectParam("id", inte);
        return wsManager.delete();
	}

}
