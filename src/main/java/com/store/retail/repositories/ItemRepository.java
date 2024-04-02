package com.store.retail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.retail.modals.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
