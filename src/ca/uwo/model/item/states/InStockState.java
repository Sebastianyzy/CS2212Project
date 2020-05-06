package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

/*
 * 	InStockState.java: Provides the logic of the deplete and 
 * 	replenish methods when the item is considered as ��in stock�� 
 * 	(i.e. has available quantities in the warehouse).
 */
public class InStockState implements ItemState{
	ItemResult itemResult;
	
	@Override
	public ItemResult deplete(Item item, int quantity) {	

		int availableQuantity = Math.abs(item.getAvailableQuantity());
		
		if ((availableQuantity == 0) || (availableQuantity <= Math.abs(quantity))) {								
			itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);
			item.setState(ItemStateFactory.create("OutOfStockState"));	
			item.notifyViewer();
		} 
		
		else{
			availableQuantity -= Math.abs(quantity);			
			if ((availableQuantity <= 10)&&(availableQuantity > 0)) {
				itemResult = new ItemResult("LOW STOCK", ResponseCode.Partially_Completed);	
				item.setState(ItemStateFactory.create("LowStockState"));				
				item.notifyViewer();
			}
			
			else {
				itemResult = new ItemResult("AVAILABLE", ResponseCode.Completed);	
			}
			
		}
		item.setAvailableQuantity(availableQuantity);

		return itemResult;
	}

	@Override
	public ItemResult replenish(Item item, int quantity) {	
		int availableQuantity = Math.abs(item.getAvailableQuantity());
		availableQuantity += Math.abs(quantity);
		item.setAvailableQuantity(availableQuantity);
		itemResult = new ItemResult("RESTOCKED", ResponseCode.Completed);
		if (availableQuantity > 10) {
			item.setState(ItemStateFactory.create("InStockState"));
		}
		return itemResult;
	}
}

