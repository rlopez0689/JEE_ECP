package es.upm.miw.web.controllers;

import java.util.List;

public interface SeeVotesController {
	public List<Object[]> getNormalVotes();	
	public List<Object[]> getEducationVotes();
}
