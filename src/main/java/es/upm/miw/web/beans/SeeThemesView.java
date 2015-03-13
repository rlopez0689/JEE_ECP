package es.upm.miw.web.beans;

import java.util.List;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.web.controllers.DeleteThemeController;

public class SeeThemesView extends ViewBean {
	
	private String message;

    private List<Theme> themes;
    
    public SeeThemesView() {
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

    public void update() {
    	DeleteThemeController deleteThemeController = this.getControllerFactory().getDeleteThemeController();
    	this.themes=deleteThemeController.getThemes();
    }

    public String process() {
        return "addTheme";
    }
}
