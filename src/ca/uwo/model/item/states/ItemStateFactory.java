package ca.uwo.model.item.states;


public class ItemStateFactory{
	/*
	 * This class implements the Factory design pattern. 
	 * It provides a method create which uses the value 
	 * of its parameter to create an object of type ItemState.
	 */
	 public static ItemState create(String state) {
		 switch(state) {
		 case ("InStockState"):
			 return new InStockState();
		 case ("LowStockState"): 
			 return new LowStockState();
		 case ("OutOfStockState"):
			 return new OutOfStockState();
		 default:
			 return new InStockState();
		 } 
	 }
	
	}
	
