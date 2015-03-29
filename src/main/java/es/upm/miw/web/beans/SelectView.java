package es.upm.miw.web.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.web.controllers.ThemeController;

@ManagedBean
@RequestScoped
public class SelectView extends ViewBean{

    private List<Theme> themes;
    
    private String idTheme;
    
    public SelectView() {
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

	public String getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(String idTheme) {
		this.idTheme = idTheme;
	}
	
	public String direccion(){
		return "voteView";
	}
	
	public String process(String id){
		this.idTheme = id;
		return "voteView";
	}
}
