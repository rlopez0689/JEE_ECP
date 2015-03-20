package es.upm.miw.web.beans;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class I18n {

    private Locale locale;

    private Date date = new Date();

    private double number = 0.23;

    private String parameter = "***";

    public I18n() {
        this.locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
   }

    public Locale getLocale() {
        return this.locale;
    }

    public Date getDate() {
        return this.date;
    }

    public double getNumber() {
        return this.number;
    }

    public String getParameter() {
        return parameter;
    }

    public String change(String language) {
        this.locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        return null;
    }

    public String msg(String key) {
        return ResourceBundle.getBundle("i18n.messages", this.locale).getString(key);
    }

}
