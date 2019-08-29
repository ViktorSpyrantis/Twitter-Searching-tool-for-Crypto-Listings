package com.cryptolistings.checking;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.cryptolistings.coin.CoinCollection;
import com.cryptolistings.coin.Coins;
import com.cryptolistings.exchange.Exchanges;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Checking {
	
	Date timeToCheck;
	List<Status> statusList = null;			// A list for the post to check
	private Exchanges exchange;

	
	// Access  tokens and stuff
	private TwitterFactory setConfigurationBuilder() {
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();

		configurationBuilder.setDebugEnabled(true)
	      .setOAuthConsumerKey("cvffNNTqkpoIe4gD8xmH69sAo")
	      .setOAuthConsumerSecret("VG8qmScisneelluCvgpFWdEZFF6eVT4NnPltQksIQIFq8AYK13")
	      .setOAuthAccessToken("938379828625108992-njo8h17OdgP41g5gOBTDQEF0275Tueo")
	      .setOAuthAccessTokenSecret("xs5WFWzLjTwypZKPbYBWlY2RmA03R4bu3qicZ8ysZrn35");
		
	    TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());
	    
	    return twitterFactory;
	}

	// The method doing the actual buisiness logic of the app
	public void checkTwitter(List<Exchanges> exchanges) {
		Twitter twitter = setConfigurationBuilder().getInstance();
		
		while(true) {
			timeToCheck = new Date(System.currentTimeMillis() - (10 * 60 * 1000000));		// Setting how recent posts we prefer (set to 10 mins now)+
			
			try {
				
				for(int i=0; i < exchanges.size(); i++) {
					exchange = exchanges.get(i);
					statusList = twitter.getUserTimeline("@" + exchange.getUserName());			// The 20 most recent statuses posted in the last 24 hours from the user are stored in this list
					
					System.out.println("EEEEEEEEEEEEEEEE          " + exchange.getUserName());
					for (Status status : statusList) {
						if(status.getCreatedAt().getTime() >= timeToCheck.getTime()) {			// Checking if the posts are as recent as we want with the timeToCheck object 
							for(int j=0; j < exchange.getKeywords().size(); j++) {				// Iterating on the keywords list of the Exchange object to check if every keyword appears on the twitter post
								if(!status.getText().contains(exchange.getKeywords().get(j)))			// The loop will break if even one keyword string does not appear on the post
									break;			
								if(j == exchange.getKeywords().size() - 1) {			// Here we check if this is the last iteration (because we cannot continue if we do not check all keyword strings). If it is, then it is time to advance to the next set of code. 
									//System.out.println(status.getText());
									String coinSymbol = status.getText().substring(status.getText().indexOf(exchange.getBefore()) + (exchange.getBefore().length()), status.getText().indexOf(exchange.getAfter()));
									System.out.println(coinSymbol);
									Coins coin = new Coins(coinSymbol, exchange.getUserName(), status.getCreatedAt());
									CoinCollection.addToList(coin);
								}
							}
						}
					}
				}
				TimeUnit.SECONDS.sleep(5);
				
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void checkExchange() {

	}
	
}
