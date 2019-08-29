package com.cryptolistings.coin;

import java.util.Date;

/*
 * This class will hold the references for each coin that has been listed in the last couple of minutes
 */


public class Coins {
	

	private String symbol;
	private String exchange;
	private Date dateOfPost;
	
	public Coins(String symbol, String exchange, Date timeListed) {
		super();
		this.symbol = symbol;
		this.exchange = exchange;
		this.setDateOfPost(timeListed);
	}
	


	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public String getExchange() {
		return exchange;
	}


	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public Date getDateOfPost() {
		return dateOfPost;
	}

	public void setDateOfPost(Date dateOfPost) {
		this.dateOfPost = dateOfPost;
	}

	

	//The methods equals and hashCode need to be overriden because a HashSet is used to store Coins objects

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
	    if (obj == null)
	    	return false;
	    if (this.getClass() != obj.getClass())
	    	return false;
	    
	    Coins that = (Coins) obj;
	    
	    if (!this.symbol.equals( that.symbol))
	    	return false;
	    if (!this.exchange.equals(that.exchange))
	    	return false;
	    if (this.dateOfPost.compareTo(that.dateOfPost) != 0)
	    	return false;
	    
		return true;
	}
	
	@Override
	public int hashCode(){
		int result = 17;
		result = 31 * result + symbol.hashCode();
		result = 31 * result + exchange.hashCode();
		result = 31 * result + dateOfPost.hashCode();
		
		return result;
	}

}
