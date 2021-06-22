package com.pantera.apiitems.client.feign;

import com.pantera.apiitems.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "products-service", url = "localhost:8001/api/products")
public interface ProductClient {

  @GetMapping
  List<Product> findAll();

  @GetMapping("/{id}")
  Product findById(@PathVariable Long id);
}
