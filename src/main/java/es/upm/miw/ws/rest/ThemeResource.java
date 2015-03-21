package es.upm.miw.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.upm.miw.persistence.models.daos.DaoFactory;
import es.upm.miw.persistence.models.daos.ThemeDao;
import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.ws.ThemeUris;
import es.upm.miw.ws.utils.ThemeWrapper;

@Path(ThemeUris.PATH_THEMES)
public class ThemeResource {
	
	@POST
    @Consumes({MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML})
    public Response create(Theme theme) {
        ThemeDao themeDao = DaoFactory.getFactory().getThemeDao();
        themeDao.create(theme);
        return Response.ok(theme).build();
    }
	
	@Path(ThemeUris.PATH_ID)
    @GET
    @Consumes(MediaType.APPLICATION_XML)
	@Produces({MediaType.APPLICATION_XML})
    public Response read(@PathParam("id") Integer id) {
        Theme theme = DaoFactory.getFactory().getThemeDao().read(id);
        return Response.ok(theme).build();
    }
	
    @GET
    @Consumes(MediaType.APPLICATION_XML)
    @Produces({MediaType.APPLICATION_XML})
    public Response readAll() {
		ThemeWrapper themeWrapper = new ThemeWrapper();
        themeWrapper.setListTheme(DaoFactory.getFactory().getThemeDao().findAll());
        return Response.ok(themeWrapper).build();
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    @Produces({MediaType.APPLICATION_XML})
    public Response delete(@PathParam("id") Integer id, @QueryParam("code") String code) {
    	if(code=="666"){
	    	DaoFactory.getFactory().getThemeDao().deleteById(id);
	        return Response.ok("Deleted").build();
        }
    	return Response.noContent().build();
    }
}
