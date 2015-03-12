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
        System.out.println(theme);
    }

    public void update() {
    }

    public String process() {
    	System.out.println(this.getControllerFactory());
        AddThemeController addThemeController = this.getControllerFactory().getAddThemeController();
    	System.out.println("Traza");
        addThemeController.addTheme(this.theme);
        return "prueba";
    }
	
	

}
