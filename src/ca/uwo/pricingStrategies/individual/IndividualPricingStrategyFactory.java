package ca.uwo.pricingStrategies.individual;

public class IndividualPricingStrategyFactory {

	public static IndividualPricingStrategy create(String type) {
		switch(type) {
		case ("strategy1"):			
			return new IndividualPricingStrategy1();
		
		case ("strategy2"):
			return new IndividualPricingStrategy2();
		
		default:		
			return new IndividualPricingStrategy1();
		}		
	}
}
