package com.cryptolistings.exchange;

import java.util.List;

/*
 * The class holding the exchanges objects. Exchanges attributes we need are their twitter usernames,
 * a list of keywords used in their listing posts and the strings we will use to extract the coin's name/symbol
 * from the rest of the post.
 */

public class Exchanges {
	private String userName;		//name as declared in the exchanges twitter username
	private List<String> keywords;		// A list containing keywords the exchanges use in their listing posts to help filter the other posts
	
	// In order to identify the name of the coin listed, we need to specify the characters before the coin's name
	// in the post as well as the characters after the name of the coin
	private String before;
	private String after;
	
	public Exchanges(String userName, List<String> keywords, String before, String after) {
		super();
		this.userName = userName;
		this.keywords = keywords;
		this.before = before;
		this.after = after;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public String getBefore() {
		return before;
	}

	public void setBefore(String before) {
		this.before = before;
	}

	public String getAfter() {
		return after;
	}

	public void setAfter(String after) {
		this.after = after;
	}
	
	
}
