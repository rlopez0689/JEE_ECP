package es.upm.miw.web.beans;

import es.upm.miw.web.controllers.DeleteThemeController;

public class DeleteView extends ViewBean {
	
	private String message="Prueba";
    
    public DeleteView() {
    }

    public String getMessage() {
        return message;
    }
	
    public String process() {
        return "addTheme";
    }

	public void deleteTheme(String id) {
			DeleteThemeController deleteThemeController = this.getControllerFactory().getDeleteThemeController();
			deleteThemeController.deleteTheme(Integer.parseInt(id));
	}
}
