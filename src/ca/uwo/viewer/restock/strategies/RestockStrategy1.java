package ca.uwo.viewer.restock.strategies;

public class RestockStrategy1 implements RestockStrategy{

	@Override
	public int calculateQuantity(String itemName, int quantity, double price) {
		// TODO Auto-generated method stub
		quantity = 50;
		return Math.abs(quantity);
	}

}
