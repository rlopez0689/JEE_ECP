package es.upm.miw.web.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "userMB")
public class HelloJSFBean{
    public String name="Hola, desde Bean. OK!!!";
    
    public String getName() {
        return name;
    }
    
    public HelloJSFBean(){
    	System.out.println("JSJSDJSDJNSJNDSJNSDJDSNJSJNSD");
    }
}
