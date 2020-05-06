package ca.uwo.proxies;

import java.util.Map;
import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

public class SupplierProxy extends Proxy{
	private static SupplierProxy instance = null;
	
	private SupplierProxy() {
	}
	
	public static SupplierProxy getInstance() {
		if (instance == null) 
			instance = new SupplierProxy();
		
		return instance;
	}

	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
	    this.setNextProxy((LowQuantityProxy.getInstance()));
		LowQuantityProxy.getInstance().placeOrder(orderDetails, buyer);
	}

	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
		Facade.getInstance().restock(restockDetails, supplier);
	}	
}
