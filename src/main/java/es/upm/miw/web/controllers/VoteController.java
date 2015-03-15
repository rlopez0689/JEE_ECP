package es.upm.miw.web.controllers;

import es.upm.miw.persistence.models.entities.Theme;


public interface VoteController extends ThemeController {
	public Theme getTheme(Integer id);	
}
