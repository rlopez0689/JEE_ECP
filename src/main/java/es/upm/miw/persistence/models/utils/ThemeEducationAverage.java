package es.upm.miw.persistence.models.utils;

public class ThemeEducationAverage {
	
	private Double average;
	private EducationLevel ed;
	
	public Double getAverage() {
		return average;
	}
	public void setAverage(Double average) {
		this.average = average;
	}
	public EducationLevel getEd() {
		return ed;
	}
	public void setEd(EducationLevel ed) {
		this.ed = ed;
	}
	
	@Override
	public String toString() {
		return "ThemeEducationAverage [average=" + average + ", ed=" + ed + "]";
	}
	
	
	
}
