package com.store.retail.services;

import org.springframework.stereotype.Service;

import com.store.retail.modals.Item;
import com.store.retail.repositories.ItemRepository;

@Service
public class ItemService {

	private ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@SuppressWarnings("deprecation")
	public Item getItemById(long id) {
		return itemRepository.getById(id);
	}

}
