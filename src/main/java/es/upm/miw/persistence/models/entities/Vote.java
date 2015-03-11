package es.upm.miw.persistence.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import es.upm.miw.persistence.models.utils.EducationLevel;

@Entity
public class Vote {
	public static final String ID = "ID";
	
	@Id
    @GeneratedValue
	private Integer id;
	
	public static final String EDUCATION_LEVEL = "EDUCATION_LEVEL";
	private EducationLevel education_level;
	
	public static final String IP = "IP";
	private String ip;
	
	public static final String VALORATION = "VALORATION";
	private Integer valoration;
	
	public static final String THEME = "THEME_ID";
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn
	private Theme theme;
	
	public Vote(EducationLevel el, String ip, Integer val, Theme th){
		this.valoration=val;
		this.education_level=el;
		this.ip=ip;
		this.theme=th;
	}
	
	public Vote(){}
	
	public Integer getId() {
		return id;
	}

	public EducationLevel getNivel_estudios() {
		return education_level;
	}
	public void setNivel_estudios(EducationLevel nivel_estudios) {
		this.education_level = nivel_estudios;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Theme getTema() {
		return theme;
	}
	public void setTema(Theme tema) {
		this.theme = tema;
	}
	public Integer getValoration() {
		return valoration;
	}

	public void setValoration(Integer valoration) {
		this.valoration = valoration;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		assert obj != null;
        Vote other = (Vote) obj;
        return id.equals(other.id) && education_level.equals(other.education_level)
                && ip.equals(other.ip) && theme.getId().equals(other.theme.getId());
	}
	
	@Override
	public String toString() {
		return "Voto [id=" + id + ", nivel_estudios=" + education_level
				+ ", ip=" + ip + ", tema="+ theme + "]";
	}	
}