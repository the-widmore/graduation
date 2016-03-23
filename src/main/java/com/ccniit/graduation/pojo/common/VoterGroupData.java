package com.ccniit.graduation.pojo.common;

import java.io.Serializable;
import java.util.List;

import com.ccniit.graduation.pojo.db.Voter;

public class VoterGroupData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7276463252781791904L;
	private String voterGroupDescription;
	private List<Voter> voters;

	public VoterGroupData() {
		super();
	}

	public VoterGroupData(String voterGroupDescription, List<Voter> voters) {
		super();
		this.voterGroupDescription = voterGroupDescription;
		this.voters = voters;
	}

	public String getVoterGroupDescription() {
		return voterGroupDescription;
	}

	public void setVoterGroupDescription(String voterGroupDescription) {
		this.voterGroupDescription = voterGroupDescription;
	}

	public List<Voter> getVoters() {
		return voters;
	}

	public void setVoters(List<Voter> voters) {
		this.voters = voters;
	}

}
