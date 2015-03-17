package es.upm.miw.web.beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import es.upm.miw.persistence.models.entities.Theme;
import es.upm.miw.persistence.models.entities.Vote;
import es.upm.miw.persistence.models.utils.EducationLevel;
import es.upm.miw.web.controllers.VoteController;

@ManagedBean
public class VoteView extends ViewBean {
		@ManagedProperty("#{param.id}")
		private int idTema;
		private Vote vote;
		private Integer[] valorations = new Integer[11];
		private List<EducationLevel> ed;
		private String selectedEd;
		private Theme theme;
				
		public VoteView(){
			System.out.println("klasklsaklsa");
			vote = new Vote();
			theme = new Theme();
		}
		
		@PostConstruct
		public void init(){
			this.ed = Arrays.asList(EducationLevel.values());
			this.assignTheme();
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

		public List<EducationLevel> getEd() {
			return ed;
		}

		public void setEd(List<EducationLevel> ed) {
			this.ed = ed;
		}

		public Integer[] getValorations() {
			return valorations;
		}

		public void setValorations(Integer[] valorations) {
			this.valorations = valorations;
		}

		public void update(){
			this.ed = Arrays.asList(EducationLevel.values());
			for(int i=0;i<11;i++){
				this.valorations[i]=i;
			}
		}
		
		public void assignTheme(){
			VoteController voteController = this.getControllerFactory().getVoteController();
			this.theme = voteController.getTheme(this.getIdTema());
		}
		
		public String direccion(){
			return "voteView";
		}

		public void procesar(){
			System.out.println("ESTE ES EL TEMA A PROCESAR");
			VoteController voteController = this.getControllerFactory().getVoteController();
			this.assignTheme();
			System.out.println(this.getSelectedEd());
			System.out.println(this.getIdTema());
			this.vote.setTema(this.theme);
			//voteController.voteTheme(this.vote);
		}

		public String getSelectedEd() {
			return selectedEd;
		}

		public void setSelectedEd(String selectedEd) {
			this.selectedEd = selectedEd;
		}
}
