package com.cryptolistings.coin;

import java.util.HashSet;
import java.util.Set;

/*
 * This class will hold an ArrayList of coins listed/about to be listed. Methods for adding an object, completely 
 * erasing the list and getting the  list are declared.
 */

public class CoinCollection {
	private static Set<Coins> coinList = new HashSet<Coins>();

	public static void addToList(Coins coin) {
		coinList.add(coin);
	}
	
	public static void eraseList() {
		coinList.clear();
	}
	
	public static Set<Coins> getCoinList() {
		return coinList;
	}


}
