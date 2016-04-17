package com.ccniit.graduation.util;

public class SystemUtils {

	private SystemUtils() {
		
	}

	public static String replaceVoteId(final String oraginalUrl, Long voteId) {
		return oraginalUrl.replace("\\{voteId\\}", String.valueOf(voteId));
	}

}
