package es.upm.miw.web.controllers;


public interface DeleteThemeController{
	
	 boolean deleteTheme(Integer id);
	 boolean authorizeDelete(String code);
	 boolean deleteTema(String code, int idTheme);
}
