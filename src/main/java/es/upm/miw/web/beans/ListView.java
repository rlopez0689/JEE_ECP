package es.upm.miw.web.beans;

import java.util.List;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.web.controllers.DeleteThemeController;

public class ListView extends ViewBean{
	private String message="Prueba";

    private List<Theme> themes;
    
    private String type;
    
    public ListView() {
    }

    public String getMessage() {
        return message;
    }

    public List<Theme> getThemes() {
        return themes;
    }

	public void setThemes(List<Theme> theme) {
        this.themes = theme;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void update() {
    	DeleteThemeController deleteThemeController = this.getControllerFactory().getDeleteThemeController();
    	this.themes=deleteThemeController.getThemes();
    }
}
