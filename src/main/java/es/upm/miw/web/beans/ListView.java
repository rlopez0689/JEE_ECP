package es.upm.miw.web.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.web.controllers.ThemeController;

@ManagedBean
public class ListView extends ViewBean{
	private String message="Prueba";

    private List<Theme> themes;
    
    @ManagedProperty(value = "#{authorizeView.getTypeList()}")
    private String type;
    
    private String methodType="get";
    
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
		if(type=="delete")
			this.setMethodType("post");
		this.type = type;
	}

	public String getMethodType() {
		return methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public void update() {
    	ThemeController themeController = this.getControllerFactory().getThemeController();
    	this.themes=themeController.getThemes();
    }
}
