package es.upm.miw.models.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Theme {
	
	public static final String TABLE = "tema";
	
	public static final String ID = "ID";	
	
	@Id
    @GeneratedValue
	private Integer id;
	
	public static final String Question = "QUESTION";
	private String question;
	
	public static final String NAME = "name";
	private String name;
	
	public Theme(String question, String name){
		this.question = question;
		this.name = name;
	}
	
	public Theme(){}
	
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
        Theme other = (Theme) obj;
        return id.equals(other.id) && name.equals(other.name)
                && question.equals(other.question);
	}
	
	@Override
	public String toString() {
		return "Tema [id=" + id + ", question=" + question + ", name=" + name
				+ "]";
	}
	
}