package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

public class LowQuantityProxy extends Proxy{
	private static LowQuantityProxy instance = null;
	
	private LowQuantityProxy() {		
	}

	public static LowQuantityProxy getInstance() {
		if (instance == null) 
			instance = new LowQuantityProxy();
		
		return instance;
	}

	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		int sum = orderDetails.get("apple")+orderDetails.get("pear")+orderDetails.get("mango")+orderDetails.get("onions");
		if(sum <= 10) {
			if(authentication(buyer.getUserName(), buyer.getPassword())) { 
				Facade.getInstance().placeOrder(orderDetails, buyer);
			}
		}
		
		else{
			this.setNextProxy(HighQuantityProxy.getInstance());
			HighQuantityProxy.getInstance().placeOrder(orderDetails, buyer);
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
