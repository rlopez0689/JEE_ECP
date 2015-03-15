package es.upm.miw.web.controllers;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.persistence.models.entities.Vote;


public interface VoteController  {
	public Theme getTheme(Integer id);	
	public boolean voteTheme(Vote vote);
}
