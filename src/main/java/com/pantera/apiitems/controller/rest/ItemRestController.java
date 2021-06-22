package com.pantera.apiitems.controller.rest;

import com.pantera.apiitems.domain.Item;
import com.pantera.apiitems.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemRestController {

  private final ItemService itemService;

  @GetMapping
  public List<Item> findAll() {
    return itemService.findAll();
  }

  @GetMapping("/{id}/quantity/{quantity}")
  public Item getItemDetail(@PathVariable Long id, @PathVariable Integer quantity) {
    return itemService.findById(id, quantity);
  }
}
