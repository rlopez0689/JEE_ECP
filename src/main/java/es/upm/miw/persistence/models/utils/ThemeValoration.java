package es.upm.miw.persistence.models.utils;

import java.util.ArrayList;

import es.upm.miw.persistence.models.entities.Theme;

public class ThemeValoration {

	private ArrayList<ThemeEducationAverage> educationAverageList;
	private Integer Valoration;
	private Theme theme;
	
	public ArrayList<ThemeEducationAverage> getEducationAverageList() {
		return educationAverageList;
	}
	
	public void setEducationAverageList(
			ArrayList<ThemeEducationAverage> educationAverageList) {
		this.educationAverageList = educationAverageList;
	}
	public Integer getValoration() {
		return Valoration;
	}
	public void setValoration(Integer valoration) {
		Valoration = valoration;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
}
