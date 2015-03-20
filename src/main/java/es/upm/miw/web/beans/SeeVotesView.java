package es.upm.miw.web.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import es.upm.miw.persistence.models.utils.ThemeValoration;
import es.upm.miw.web.controllers.SeeVotesController;

@ManagedBean
public class SeeVotesView extends ViewBean {
	
	private List<ThemeValoration> groupVotes;
	
	public List<ThemeValoration> getgroupVotes() {
		return groupVotes;
	}

	public void setgroupVotes(List<ThemeValoration> groupVotes) {
		this.groupVotes = groupVotes;
	}
	
	@PostConstruct
	public void procesar() {
		System.out.println("Procesar");
		SeeVotesController voteController = this.getControllerFactory().getSeeVotesController();
		this.setgroupVotes(voteController.getEducationVotes());
	}
}
