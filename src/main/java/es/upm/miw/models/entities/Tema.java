package es.upm.miw.models.entities;

public class Tema {
	
	public static final String TABLE = "tema";
	
	public static final String ID = "ID";	
	private Integer id;
	
	public static final String Question = "QUESTION";
	private String question;
	
	public static final String NAME = "name";
	private String name;
	
	public Tema(String question, String name){
		this.question = question;
		this.name = name;
	}
	
	public Tema(){}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		assert obj != null;
        Tema other = (Tema) obj;
        return id.equals(other.id) && name.equals(other.name)
                && question.equals(other.question);
	}
	
	@Override
	public String toString() {
		return "Tema [id=" + id + ", question=" + question + ", name=" + name
				+ "]";
	}
	
}
