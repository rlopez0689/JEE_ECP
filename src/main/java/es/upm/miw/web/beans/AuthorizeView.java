package es.upm.miw.web.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AuthorizeView extends ViewBean {
	
	private String message="Prueba";
	
	private String code;
	
    public AuthorizeView() {
    }

    public String getMessage() {
        return message;
    }
	
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
    public String authorize() {
        if(this.getCode().equals("666"))
        	return "listThemes";
        else
        	return "authorizeThemes";
    }
       
    public boolean isAuthorized(){
    	return this.getCode().equals("666");
    }
}
