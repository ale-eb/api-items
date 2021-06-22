package com.pantera.apiitems.service.impl;

import com.pantera.apiitems.domain.Item;
import com.pantera.apiitems.domain.Product;
import com.pantera.apiitems.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

  private final RestTemplate restTemplate;

  @Override
  public List<Item> findAll() {
    List<Product> products = Arrays.asList(restTemplate.getForObject("http://localhost:8001/api/products", Product[].class));
    return products.stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
  }

  @Override
  public Item findById(Long id, Integer quantity) {
    Map<String, String> pathVariables = new HashMap<>();
    pathVariables.put("id", String.valueOf(id));
    Product product = restTemplate.getForObject("http://localhost:8001/api/products/{id}", Product.class, pathVariables);
    return new Item(product, quantity);
  }
}
