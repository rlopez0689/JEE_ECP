package es.upm.miw.web.controllers;

public abstract class ControllerFactory {
	
	public abstract AddThemeController getAddThemeController();
	public abstract DeleteThemeController getDeleteThemeController();
	public abstract SeeVotesController getSeeVotesController();
	public abstract VoteController getVoteController();
}
