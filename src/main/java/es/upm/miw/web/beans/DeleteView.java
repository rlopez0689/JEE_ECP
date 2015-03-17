package es.upm.miw.web.beans;

import javax.faces.bean.ManagedBean;

import es.upm.miw.web.controllers.DeleteThemeController;

@ManagedBean
public class DeleteView extends ViewBean {
	
	private String message="Prueba";
    
    public DeleteView() {
    }

    public String getMessage() {
        return message;
    }
    	
	public String deleteTheme(String id) {
		DeleteThemeController deleteThemeController = this.getControllerFactory().getDeleteThemeController();
		deleteThemeController.deleteTheme(Integer.parseInt(id));
		return null;
	}
}
