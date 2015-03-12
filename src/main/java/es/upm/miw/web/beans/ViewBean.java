package es.upm.miw.web.beans;

import javax.faces.bean.ManagedProperty;

import es.upm.miw.web.controllers.ControllerFactory;

public abstract class ViewBean {

    @ManagedProperty(value = "#{controllerFactory}")
    private ControllerFactory controllerFactory;

    public void setControllerFactory(ControllerFactory controllerFactory) {
    	System.out.println("INYECCION");
        this.controllerFactory = controllerFactory;
    }

    protected ControllerFactory getControllerFactory() {
    	System.out.println("Regresar view bean factoria");
        return controllerFactory;
    }

}
