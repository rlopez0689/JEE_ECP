package es.upm.miw.web.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.web.controllers.ThemeController;

@ManagedBean
public class SelectView extends ViewBean{
	private String message="Prueba";

    private List<Theme> themes;
    
    public SelectView() {
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
	
	@PostConstruct
	public void init(){
		this.update();
	}

	public void update() {
    	ThemeController themeController = this.getControllerFactory().getThemeController();
    	this.themes=themeController.getThemes();
    }
}
