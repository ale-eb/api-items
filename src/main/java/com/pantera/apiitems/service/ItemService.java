package com.pantera.apiitems.service;

import com.pantera.apiitems.domain.Item;

import java.util.List;

public interface ItemService {

  List<Item> findAll();
  Item findById(Long id, Integer quantity);
}
