package es.upm.miw.ws.rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.upm.miw.persistence.models.daos.DaoFactory;
import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.persistence.models.utils.ThemeValoration;
import es.upm.miw.ws.VoteUris;
import es.upm.miw.ws.utils.ThemeValorationWrapper;

@Path(VoteUris.PATH_VOTACIONES)
public class VoteResource {
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
    public Response getVotes() {
		List<ThemeValoration> selectedVotesList = new ArrayList<ThemeValoration>();
		List<Theme> themes = new ArrayList<Theme>();
		themes = DaoFactory.getFactory().getThemeDao().findAll();
		for(int i=0; i<themes.size(); i++){
			ThemeValoration selectedVote = new ThemeValoration();
			selectedVote.setEducationAverageList(DaoFactory.getFactory().getVoteDao().getAverageVotesByEducationLevel(themes.get(i)));
			selectedVote.setValoration(DaoFactory.getFactory().getVoteDao().getNumberOfVotes(themes.get(i)));
			selectedVote.setTheme(themes.get(i));
			selectedVotesList.add(selectedVote);
		}
		ThemeValorationWrapper themeValorationWrapper = new ThemeValorationWrapper();
		themeValorationWrapper.setlistThemeValoration(selectedVotesList);
		return Response.ok(themeValorationWrapper).build();
	}
}
