package com.ccniit.graduation.pojo.qo;

public class AuthorSettingUpdater extends AuthorUpdater {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8960299119449702267L;

	private boolean setLinkmanNotify;
	private boolean setVoteFinishNotify;
	private boolean setDataExpireNotify;
	private String setPrimaryNofify;

	public AuthorSettingUpdater() {
	}

	public AuthorSettingUpdater(long id) {
		super(id);
	}

	public boolean isSetLinkmanNotify() {
		return setLinkmanNotify;
	}

	public void setSetLinkmanNotify(boolean setLinkmanNotify) {
		this.setLinkmanNotify = setLinkmanNotify;
	}

	public boolean isSetVoteFinishNotify() {
		return setVoteFinishNotify;
	}

	public void setSetVoteFinishNotify(boolean setVoteFinishNotify) {
		this.setVoteFinishNotify = setVoteFinishNotify;
	}

	public boolean isSetDataExpireNotify() {
		return setDataExpireNotify;
	}

	public void setSetDataExpireNotify(boolean setDataExpireNotify) {
		this.setDataExpireNotify = setDataExpireNotify;
	}

	public String getSetPrimaryNofify() {
		return setPrimaryNofify;
	}

	public void setSetPrimaryNofify(String setPrimaryNofify) {
		this.setPrimaryNofify = setPrimaryNofify;
	}

}
