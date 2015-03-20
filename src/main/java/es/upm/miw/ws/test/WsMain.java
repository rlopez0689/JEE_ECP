package es.upm.miw.ws.test;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.ws.rest.ThemeResource;

public class WsMain {

	public static void main(String[] args) {
		ThemeResource themeRes = new ThemeResource();
		themeRes.create(new Theme("pruebarest","pruebarest"));
	}

}
