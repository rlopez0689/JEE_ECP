package es.upm.miw.ws.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import es.upm.miw.persistence.models.utils.ThemeValoration;

@XmlRootElement
public class ThemeValorationWrapper {
	private List<ThemeValoration> listThemeValoration;
	
	public ThemeValorationWrapper(){}

	public List<ThemeValoration> getlistThemeValoration() {
		return listThemeValoration;
	}

	public void setlistThemeValoration(List<ThemeValoration> listThemeValoration) {
		this.listThemeValoration = listThemeValoration;
	}
}
