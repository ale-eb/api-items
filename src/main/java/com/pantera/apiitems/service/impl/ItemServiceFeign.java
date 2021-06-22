package com.pantera.apiitems.service.impl;

import com.pantera.apiitems.client.feign.ProductClient;
import com.pantera.apiitems.domain.Item;
import com.pantera.apiitems.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Primary
public class ItemServiceFeign implements ItemService {

  private final ProductClient feignClient;

  @Override
  public List<Item> findAll() {
    return feignClient.findAll().stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
  }

  @Override
  public Item findById(Long id, Integer quantity) {
    return new Item(feignClient.findById(id), quantity);
  }
}
