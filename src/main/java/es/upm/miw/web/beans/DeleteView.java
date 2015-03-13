package es.upm.miw.web.beans;

import java.util.List;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.web.controllers.DeleteThemeController;

public class DeleteView extends ViewBean {
	
	private String message="Prueba";
	
	private String code;

    private List<Theme> themes;
    
    public DeleteView() {
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
	
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void update() {
    	DeleteThemeController deleteThemeController = this.getControllerFactory().getDeleteThemeController();
    	this.themes=deleteThemeController.getThemes();
    }
	
	public void verifyCode(){
		
	}

    public String process() {
        return "addTheme";
    }

	public void deleteTheme(String id) {
		DeleteThemeController deleteThemeController = this.getControllerFactory().getDeleteThemeController();
		deleteThemeController.deleteTheme(Integer.parseInt(id));
	}
}
