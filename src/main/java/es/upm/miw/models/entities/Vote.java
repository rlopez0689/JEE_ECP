package es.upm.miw.models.entities;

public class Vote {
	public static final String ID = "ID";
	private Integer id;
	
	public static final String EDUCATION_LEVEL = "EDUCATION_LEVEL";
	private String education_level;
	
	public static final String IP = "IP";
	private String ip;
	
	public static final String VOTE_NUMBER = "VOTE_NUMBER";
	private Integer numero_votos;
	
	public static final String THEME = "THEME_ID";
	private Theme theme;
	
	public String getNivel_estudios() {
		return education_level;
	}
	public void setNivel_estudios(String nivel_estudios) {
		this.education_level = nivel_estudios;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getNumero_votos() {
		return numero_votos;
	}
	public void setNumero_votos(int numero_votos) {
		this.numero_votos = numero_votos;
	}
	public Theme getTema() {
		return theme;
	}
	public void setTema(Theme tema) {
		this.theme = tema;
	}
	
	@Override
	public boolean equals(Object obj) {
		assert obj != null;
        Vote other = (Vote) obj;
        return id.equals(other.id) && education_level.equals(other.education_level)
                && ip.equals(other.ip) && theme.getId().equals(other.theme.getId())
                && numero_votos.equals(other.numero_votos);
	}
	
	@Override
	public String toString() {
		return "Voto [id=" + id + ", nivel_estudios=" + education_level
				+ ", ip=" + ip + ", numero_votos=" + numero_votos + ", tema="
				+ theme + "]";
	}
	
}
