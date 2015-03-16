package es.upm.miw.web.beans;

import javax.faces.bean.ManagedBean;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.web.controllers.AddThemeController;

@ManagedBean
public class AddView extends ViewBean {
	
	private String message;

    private Theme theme;
    
    private String prueba;

    public AddView() {
    	this.theme = new Theme();
    }

    public String getMessage() {
        return message;
    }

    public Theme getTheme() {
        return theme;
    }

	public String getPrueba() {
		return prueba;
	}

	public void setPrueba(String prueba) {
		this.prueba = prueba;
	}

	public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public void update() {
    }

    public String process() {
        AddThemeController addThemeController = this.getControllerFactory().getAddThemeController();
        addThemeController.addTheme(this.theme);
        this.message="Tema agregado correctamente";
        return "addTheme";
    }
	
	

}
