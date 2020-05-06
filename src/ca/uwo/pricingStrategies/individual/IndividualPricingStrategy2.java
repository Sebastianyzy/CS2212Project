package ca.uwo.pricingStrategies.individual;

public class IndividualPricingStrategy2 implements IndividualPricingStrategy{

	@Override
	public double calculate(int quantity, double price) {
		// TODO Auto-generated method stub
		double itemPrice = quantity * price;
		double finalPrice = itemPrice * 0.9;
		if (finalPrice > 1000) { 
			finalPrice = finalPrice * 0.95;
		}
		return Math.abs(finalPrice);
		
	}

}
