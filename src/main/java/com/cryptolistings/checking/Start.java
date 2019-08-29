package com.cryptolistings.checking;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.cryptolistings.exchange.ExchangeInit;
import com.cryptolistings.json.JsonGen;


public class Start implements ServletContextListener, Runnable{
	Start start = new Start();
	Checking checking = new Checking();
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		Thread thread1 = new Thread(start);
		thread1.start();
	}

	@Override
	public void run() {
		checking.checkTwitter(ExchangeInit.getExchangesList());
		JsonGen.generateJsonObjects();
	}

}
