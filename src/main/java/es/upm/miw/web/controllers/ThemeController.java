package es.upm.miw.web.controllers;

import java.util.List;

import es.upm.miw.persistence.models.entities.Theme;

public interface ThemeController {
	public List<Theme> getThemes();
}
