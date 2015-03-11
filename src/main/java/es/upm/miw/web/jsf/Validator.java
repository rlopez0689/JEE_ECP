package es.upm.miw.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class Validator {
    private Integer tInt;

    private Byte tByte;

    private Double tDouble;

    private String pass;

    private String mSet;

    // Getters & setters
    public Integer gettInt() {
        return tInt;
    }

    public void settInt(Integer tInt) {
        this.tInt = tInt;
    }

    public Byte gettByte() {
        return tByte;
    }

    public void settByte(Byte tByte) {
        this.tByte = tByte;
    }

    public Double gettDouble() {
        return tDouble;
    }

    public void settDouble(Double tDouble) {
        this.tDouble = tDouble;
    }

    public String getmSet() {
        return mSet;
    }

    public void setmSet(String mSet) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (mSet.equals("1234"))
            context.addMessage("form:mSet", new FacesMessage("Valor 1234 no permitido"));
        this.pass = pass.trim();
        this.mSet = mSet;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public String process() {
        // Se valida con la capa de negocio o se relacionan campos
        FacesContext context = FacesContext.getCurrentInstance();
        if (this.getmSet().equals(this.getPass()))
            context.addMessage("form", new FacesMessage("pass no debe coincidir con mSet"));
        if (context.getMessageList().size() > 0)
            return null;
        else {
            return ("validator");
        }
    }
}
