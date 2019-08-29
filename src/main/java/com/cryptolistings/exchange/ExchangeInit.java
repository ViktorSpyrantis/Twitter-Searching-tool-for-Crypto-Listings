package com.cryptolistings.exchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * The class that will initialize the Exchanges objects in a static initilizer.
 */

public class ExchangeInit {
	private final static Exchanges binance;
	private final static Exchanges coinEgg;
	private final static Exchanges digiFinex;
	private final static List<Exchanges> exchangesList;
	

	static {
		//binance = new Exchanges("binance", Arrays.asList("#Binance Lists"), "( $", ")");
		binance = new Exchanges("binance", Arrays.asList("#BinanceMeetupCDMX"), "WeWork", " #Ref");
		coinEgg = new Exchanges("CoinEgg_LTD", Arrays.asList("[#Announcement]", "will list"), "", "");
		digiFinex = new Exchanges("DigiFinex", Arrays.asList("DigiFinex is going to list"), " (", ") ");
		
		exchangesList = new ArrayList<>();
		exchangesList.addAll(Arrays.asList(binance, coinEgg, digiFinex));
	}
	
	public static List<Exchanges> getExchangesList(){
		return exchangesList;
	}
	

}
