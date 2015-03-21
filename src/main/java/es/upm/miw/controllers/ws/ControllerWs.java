package es.upm.miw.controllers.ws;

abstract class ControllerWs {

    private static final String PROTOCOL = "http";

    private static final String HOST = "localhost";

    private static final int PORT = 8080;

    private static final String WEB = "/JEE_ECP/rest";

    private static final String URI = PROTOCOL + "://" + HOST + ":" + PORT + WEB;

    protected ControllerWs() {}
    
    protected static WsManager buildWebServiceManager(String... paths){
        return new WsManager(URI, paths);
    }

}
