package es.upm.miw.web.beans;

import java.util.List;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.web.controllers.DeleteThemeController;

public class DeleteThemeView extends ViewBean {
	
	private String message;

    private List<Theme> theme;
    
    public DeleteThemeView() {
    }

    public String getMessage() {
        return message;
    }

    public List<Theme> getTheme() {
        return theme;
    }

	public void setTheme(List<Theme> theme) {
        this.theme = theme;
    }

    public void update() {

    }

    public String process() {
        DeleteThemeController deleteThemeController = this.getControllerFactory().getDeleteThemeController();
        deleteThemeController.deleteTheme(this.theme);
        this.message="Tema agregado correctamente";
        return "addTheme";
    }
}
