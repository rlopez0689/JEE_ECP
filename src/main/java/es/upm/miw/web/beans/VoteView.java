package es.upm.miw.web.beans;

import java.util.ArrayList;
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
		private List<Integer> valorations = new ArrayList<Integer>();
		private List<EducationLevel> ed;
		private String selectedEd;
		private String selectedVal;
		private String usedIp;
		private Theme theme;
				
		public VoteView(){
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

		public List<Integer> getValorations() {
			return valorations;
		}

		public void setValorations(List<Integer> valorations) {
			this.valorations = valorations;
		}

		public void update(){
			for(int i=0;i<10;i++){
				this.valorations.add(i);
			}
			this.ed = Arrays.asList(EducationLevel.values());
		}
		
		public void assignTheme(){
			VoteController voteController = this.getControllerFactory().getVoteController();
			this.theme = voteController.getTheme(this.getIdTema());
		}
		
		public String direccion(){
			return "selectTheme";
		}

		public void procesar(){
			VoteController voteController = this.getControllerFactory().getVoteController();
			this.assignTheme();
			this.vote.setNivel_estudios(EducationLevel.valueOf(this.getSelectedEd()));
			this.vote.setIp(this.getUsedIp());
			this.vote.setValoration(Integer.parseInt(this.getSelectedVal()));
			this.vote.setTema(this.theme);
			voteController.voteTheme(this.vote);
		}

		public String getSelectedEd() {
			return selectedEd;
		}

		public void setSelectedEd(String selectedEd) {
			this.selectedEd = selectedEd;
		}

		public String getSelectedVal() {
			return selectedVal;
		}

		public void setSelectedVal(String selectedVal) {
			this.selectedVal = selectedVal;
		}

		public String getUsedIp() {
			return usedIp;
		}

		public void setUsedIp(String usedIp) {
			this.usedIp = usedIp;
		}
}