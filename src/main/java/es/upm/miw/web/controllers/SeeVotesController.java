package es.upm.miw.web.controllers;

import java.util.List;
import es.upm.miw.persistence.models.utils.ThemeValoration;

public interface SeeVotesController {
	public List<ThemeValoration> getEducationVotes();
}
