package com.cryptolistings.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cryptolistings.checking.Checking;
import com.cryptolistings.coin.CoinCollection;
import com.cryptolistings.coin.Coins;
import com.cryptolistings.exchange.ExchangeInit;
	


public class AppMain {
	
	
	static Coins  coin;

	public static void main(String[] args) throws ParseException {
		coin =  new Coins("ETH", "binance", new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"));
		CoinCollection.addToList(coin);
		coin =  new Coins("BTC", "binance",  new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"));
		CoinCollection.addToList(coin);
		coin =  new Coins("XMR", "eeeeee",  new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"));
		CoinCollection.addToList(coin);
		coin =  new Coins("ETH", "binance",  new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"));
		CoinCollection.addToList(coin);
		coin =  new Coins("ETH", "binance",  new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"));
		CoinCollection.addToList(coin);
		
		System.out.println(CoinCollection.getCoinList().size());
		for(Coins coinnn : CoinCollection.getCoinList())
			System.out.println(coinnn.hashCode());
		
		Checking checking = new Checking();
		checking.checkTwitter(ExchangeInit.getExchangesList());
		
		/*
		System.out.println("fok oph");
		ConfigurationBuilder cb = new ConfigurationBuilder();

	    cb.setDebugEnabled(true)
	      .setOAuthConsumerKey("cvffNNTqkpoIe4gD8xmH69sAo")
	      .setOAuthConsumerSecret("VG8qmScisneelluCvgpFWdEZFF6eVT4NnPltQksIQIFq8AYK13")
	      .setOAuthAccessToken("938379828625108992-njo8h17OdgP41g5gOBTDQEF0275Tueo")
	      .setOAuthAccessTokenSecret("xs5WFWzLjTwypZKPbYBWlY2RmA03R4bu3qicZ8ysZrn35");
	    TwitterFactory tf = new TwitterFactory(cb.build());

	    Twitter twitter = tf.getInstance();

	    List<Status> statusList = null;

	   try {
	        statusList = twitter.getUserTimeline("@binance");
	        //System.out.println(twitter.getUserTimeline("@binance"));
	        


	    } catch (TwitterException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	   Date currentDate = new Date(System.currentTimeMillis());		//current date
       Date dateBefore10Mins = new Date(System.currentTimeMillis() - (10 * 60 * 1000));		//date before 10 minutes
	    for (Status status : statusList) {
	    	//if(status.getCreatedAt().getTime() >= dateBefore10Mins.getTime()) {
	    		System.out.println(status.getText());
	    		//System.out.println(status.toString());
	    		Date date = status.getCreatedAt();
	    		//System.out.println(date.getTime() + "      " + date);
	    		//System.out.println(currentDate.getTime());
	    		//System.out.println(dateBefore10Mins.getTime());
	    	//}
	    	
	    	
	    }  
	 */
	}
}


