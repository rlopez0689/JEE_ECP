package es.upm.miw.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.upm.miw.persistence.models.daos.DaoFactory;
import es.upm.miw.persistence.models.daos.ThemeDao;
import es.upm.miw.persistence.models.entities.Theme;

public class ThemeResource {
	
	@POST
    @Consumes({MediaType.APPLICATION_XML})
    public Response create(Theme theme) {
        ThemeDao themeDao = DaoFactory.getFactory().getThemeDao();
        themeDao.create(theme);
        return Response.ok(theme).build();
    }
}
