package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

/*
 * Provides the logic of the deplete and replenish methods 
 * when the item is considered as ��low stock�� (i.e. there 
 * are less than 10 available items in the warehouse).
 */
public class LowStockState implements ItemState {
	ItemResult itemResult;

	@Override
	public ItemResult deplete(Item item, int quantity) {	

		int availableQuantity = Math.abs(item.getAvailableQuantity());
		if ((availableQuantity == 0) || (availableQuantity <= Math.abs(quantity))) {	
			itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);
			item.setState(ItemStateFactory.create("OutOfStockState"));					
			item.notifyViewer();
		} 
		else {
			availableQuantity -= Math.abs(quantity);
			
			if ((availableQuantity <= 10)&&(availableQuantity > 0)) {
				itemResult = new ItemResult("LOW STOCK", ResponseCode.Partially_Completed);		
				item.notifyViewer();
			}
			
			else{			
				itemResult = new ItemResult("AVAILABLE", ResponseCode.Completed);	
				item.setState(ItemStateFactory.create("InStockState"));
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
