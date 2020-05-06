package ca.uwo.viewer.restock.strategies;



public class RestockStrategyFactory {

	public static RestockStrategy create(String type) {
		switch(type) {
		case("strategy1"):
			return new RestockStrategy1();
		case("strategy2"):
			return new RestockStrategy2();
		default:		
			return new RestockStrategy1();
		}	
	}
}
