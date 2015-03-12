package es.upm.miw.web.beans;

import es.upm.miw.persistence.models.entities.Theme;

public class AddView {
	
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
    	/*
        if (this.AddView.getId() == 666 && !this.AddView.getNombre().equals("Demonio")) {
            this.errorMsg = "Sólo se acepta el nombre 'Demonio'";
            return "persona";
        } else {
            LogManager.getLogger(PersonaView.class).debug(
                    "Se accede a la capa de negocio para registrar persona: " + persona);
            return "home";AddView
        }
        */
    	return "prueba";
    }
	
	

}
