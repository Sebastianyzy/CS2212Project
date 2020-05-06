package ca.uwo.pricingStrategies.individual;

public class IndividualPricingStrategy1 implements IndividualPricingStrategy{

	@Override
	public double calculate(int quantity, double price) {
		// TODO Auto-generated method stub
		double itemPrice = quantity * price;
		if (itemPrice > 1000) {
			itemPrice = itemPrice * 0.95;
		}
		return Math.abs(itemPrice);
	
	}

}
