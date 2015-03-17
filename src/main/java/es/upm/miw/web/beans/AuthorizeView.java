package es.upm.miw.web.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AuthorizeView extends ViewBean {
	
	private String message="Prueba";
	
	private String code;
	
	private String typeList;
	
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
        if(this.getCode().equals("666")){
        	this.setTypeList("delete");
        	return "listThemes";
        }
        else
        	return "authorizeThemes";
    }
       
    public boolean isAuthorized(){
    	return this.getCode().equals("666");
    }

	public String getTypeList() {
		return typeList;
	}

	public void setTypeList(String typeList) {
		this.typeList = typeList;
	}
}
