package com.cryptolistings.json;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;

import com.cryptolistings.coin.CoinCollection;
import com.cryptolistings.coin.Coins;

public class JsonGen {
	
	private static List<JSONObject> coinJsonList;
	
	public static void generateJsonObjects() {
		Thread thread = new Thread() {
			public void run(){
				for(Coins coinList : CoinCollection.getCoinList()) {
					JSONObject json = new JSONObject();
					coinJsonList = new ArrayList<>();
					
					json.put("Symbol", coinList.getSymbol());
					json.put("Exchange", coinList.getExchange());
					json.put("Date", coinList.getDateOfPost());
					
					coinJsonList.add(json);
				}
				System.out.println("DEN ME THELOUN");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
	}
	
	public static String getJsonList() {
		if(coinJsonList == null)
			return ("{}");
		else
			return coinJsonList.toString();
		
	}
	

}
