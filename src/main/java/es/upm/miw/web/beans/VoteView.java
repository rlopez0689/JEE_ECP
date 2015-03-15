package es.upm.miw.web.beans;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.persistence.models.entities.Vote;
import es.upm.miw.persistence.models.utils.EducationLevel;
import es.upm.miw.web.controllers.VoteController;

public class VoteView extends ViewBean {

		private int idTema;
		private Vote vote;
		private Integer[] valorations = new Integer[11];
		private EducationLevel[] ed;
		private Theme theme;
				
		public VoteView(){
			vote = new Vote();
			theme = new Theme();
		}

		public int getIdTema() {
			return idTema;
		}

		public void setIdTema(int idTema) {
			this.idTema = idTema;
		}

		public Vote getVote() {
			return vote;
		}

		public void setVote(Vote vote) {
			this.vote = vote;
		}
		
		public Theme getTheme() {
			return theme;
		}

		public void setTheme(Theme theme) {
			this.theme = theme;
		}

		public EducationLevel[] getEd() {
			return ed;
		}

		public void setEd(EducationLevel[] ed) {
			this.ed = ed;
		}

		public Integer[] getValorations() {
			return valorations;
		}

		public void setValorations(Integer[] valorations) {
			this.valorations = valorations;
		}

		public void update(){
			this.ed = EducationLevel.values();
			for(int i=0;i<11;i++){
				this.valorations[i]=i;
			}
		}
		
		public void assignTheme(){
			VoteController voteController = this.getControllerFactory().getVoteController();
			this.theme = voteController.getTheme(this.getIdTema());
		}

		public void procesar(){
			VoteController voteController = this.getControllerFactory().getVoteController();
			this.assignTheme();
			this.vote.setTema(this.theme);
			voteController.voteTheme(this.vote);
		}
}
