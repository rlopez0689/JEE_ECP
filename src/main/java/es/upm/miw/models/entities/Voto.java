package es.upm.miw.models.entities;

public class Voto {
	public static final String ID = "ID";
	private Integer id;
	
	public static final String NIVEL_ESTUDIOS = "NIVEL_ESTUDIOS";
	private String nivel_estudios;
	
	public static final String IP = "IP";
	private String ip;
	
	public static final String NUMERO_VOTOS = "NUMERO_VOTOS";
	private Integer numero_votos;
	
	public static final String TEMA = "TEMA_ID";
	private Tema tema;
	
	public String getNivel_estudios() {
		return nivel_estudios;
	}
	public void setNivel_estudios(String nivel_estudios) {
		this.nivel_estudios = nivel_estudios;
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
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	@Override
	public boolean equals(Object obj) {
		assert obj != null;
        Voto other = (Voto) obj;
        return id.equals(other.id) && nivel_estudios.equals(other.nivel_estudios)
                && ip.equals(other.ip) && tema.getId().equals(other.tema.getId())
                && numero_votos.equals(other.numero_votos);
	}
	
	@Override
	public String toString() {
		return "Voto [id=" + id + ", nivel_estudios=" + nivel_estudios
				+ ", ip=" + ip + ", numero_votos=" + numero_votos + ", tema="
				+ tema + "]";
	}
}
