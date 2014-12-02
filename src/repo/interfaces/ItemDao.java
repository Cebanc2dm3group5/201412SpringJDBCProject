package repo.interfaces;

import repo.objects.Item;

public interface ItemDao {
	
	Item getItem(String itemId);
	
	void updateItem(Item item);
	
	void insertItem(Item item);
	
	void deleteItem(String itemId);
}
