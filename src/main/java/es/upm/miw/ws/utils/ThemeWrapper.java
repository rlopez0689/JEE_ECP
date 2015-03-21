package es.upm.miw.ws.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import es.upm.miw.persistence.models.entities.Theme;

@XmlRootElement
public class ThemeWrapper {

	private List<Theme> listTheme;
	
	public ThemeWrapper(){}

	public List<Theme> getListTheme() {
		return listTheme;
	}

	public void setListTheme(List<Theme> listTheme) {
		this.listTheme = listTheme;
	}
	
	
}
