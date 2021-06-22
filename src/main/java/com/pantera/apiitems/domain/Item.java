package com.pantera.apiitems.domain;

import lombok.Data;

@Data
public class Item {

  private Product product;
  private Integer quantity;

  public Item(Product product, Integer quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Double getTotal() {
    return product.getPrice() * quantity.doubleValue();
  }
}
