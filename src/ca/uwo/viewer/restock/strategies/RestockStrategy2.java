package ca.uwo.viewer.restock.strategies;

public class RestockStrategy2 implements RestockStrategy {

	@Override
	public int calculateQuantity(String itemName, int quantity, double price) {
		// TODO Auto-generated method stub
		if(itemName.contentEquals("pear")) {
			quantity = 1000;
			return Math.abs(quantity);
		}
		else if(itemName.contentEquals("apple")) {
			quantity = 100;
			return Math.abs(quantity);
		}
		else{
			quantity = 25;
			return Math.abs(quantity);
		}
	}

}
