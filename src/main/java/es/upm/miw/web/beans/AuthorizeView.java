package es.upm.miw.web.beans;

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
    	System.out.println(this.getCode()+" codigo");
        if(this.getCode().equals("666"))
        	return "listThemes";
        else
        	return "authorizeThemes";
    }
    
    public boolean isAuthorized(){
    	return this.getCode().equals("666");
    }
}
