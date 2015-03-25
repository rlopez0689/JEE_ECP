package es.upm.miw.web.beans;

import javax.faces.bean.ManagedBean;

import es.upm.miw.web.controllers.DeleteThemeController;

@ManagedBean
public class AuthorizeView extends ViewBean {
	
	private String message;
	
	private String code;
	
	private String typeList;
	
    public AuthorizeView() {
    }
	
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
    public String authorize() {
        if(this.isAuthorized()){
        	this.setTypeList("delete");
        	return "listThemes";
        }
        else{
        	this.message="Codigo incorrecto";
        	return "authorizeThemes";
        }
    }
       
    public boolean isAuthorized(){
    	DeleteThemeController deleteThemeController = this.getControllerFactory().getDeleteThemeController();
        return deleteThemeController.authorizeDelete(this.getCode());
    }

	public String getTypeList() {
		return typeList;
	}

	public void setTypeList(String typeList) {
		this.typeList = typeList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
