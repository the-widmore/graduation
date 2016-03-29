package com.ccniit.graduation.pojo.qo;

/**
 * Author设置更新器
 */
public class AuthorConfigUpdater extends AuthorUpdater {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1991978115959404014L;

	public static enum PrimaryNofify {
		phone, email, both
	}

	private boolean setLinkmanNotify;
	private boolean setFinishNotify;
	private boolean setDataExpireNotify;
	private PrimaryNofify setPrimaryNofify;

	public AuthorConfigUpdater() {
		super();
	}

	public AuthorConfigUpdater(long id) {
		super(id);
	}

	public AuthorConfigUpdater(boolean setLinkmanNotify, boolean setFinishNotify, boolean setDataExpireNotify,
			PrimaryNofify setPrimaryNofify) {
		super();
		this.setLinkmanNotify = setLinkmanNotify;
		this.setFinishNotify = setFinishNotify;
		this.setDataExpireNotify = setDataExpireNotify;
		this.setPrimaryNofify = setPrimaryNofify;
	}

	public boolean isSetLinkmanNotify() {
		return setLinkmanNotify;
	}

	public void setSetLinkmanNotify(boolean setLinkmanNotify) {
		this.setLinkmanNotify = setLinkmanNotify;
	}

	public boolean isSetFinishNotify() {
		return setFinishNotify;
	}

	public void setSetFinishNotify(boolean setFinishNotify) {
		this.setFinishNotify = setFinishNotify;
	}

	public boolean isSetDataExpireNotify() {
		return setDataExpireNotify;
	}

	public void setSetDataExpireNotify(boolean setDataExpireNotify) {
		this.setDataExpireNotify = setDataExpireNotify;
	}

	public PrimaryNofify getSetPrimaryNofify() {
		return setPrimaryNofify;
	}

	public void setSetPrimaryNofify(PrimaryNofify setPrimaryNofify) {
		this.setPrimaryNofify = setPrimaryNofify;
	}

}
