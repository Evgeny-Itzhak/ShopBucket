package home.dao;

import home.model.Item;

import java.util.List;

public interface ItemDAO {
	public void save(Item item);
	public void update(Item item);
	public void delete(int itemId);
	public Item get(int itemId);
	public List<Item> list();
}
