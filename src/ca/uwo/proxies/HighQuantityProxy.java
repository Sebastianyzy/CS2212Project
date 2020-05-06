package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

public class HighQuantityProxy extends Proxy{
	private static HighQuantityProxy instance = null;


	
	private HighQuantityProxy() {		
	}

	public static HighQuantityProxy getInstance() {
		if (instance == null) 
			instance = new HighQuantityProxy();
		
		return instance;
	}
	
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		if(authentication(buyer.getUserName(), buyer.getPassword())) {
			Facade.getInstance().placeOrder(orderDetails, buyer);			
		}	
	}

	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {	
		Facade.getInstance().restock(restockDetails, supplier);
	}
	
	private boolean authentication(String name, String pass) {
		if((name.contains("s"))&&(pass.contains("1"))) {
			return true;
		}
		return false;
	}

}
