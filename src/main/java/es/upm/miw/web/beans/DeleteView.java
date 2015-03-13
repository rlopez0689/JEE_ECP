package es.upm.miw.web.beans;

import es.upm.miw.persistence.models.entities.Theme;

public class DeleteView extends ViewBean {
	
	private String message="Prueba";

    private Theme theme;
    
    public DeleteView() {
    }

    public String getMessage() {
        return message;
    }

    public Theme getThemes() {
        return theme;
    }

	public void setThemes(Theme theme) {
        this.theme = theme;
    }

    public void update() {
    }

    public String process() {
        return "addTheme";
    }
}
