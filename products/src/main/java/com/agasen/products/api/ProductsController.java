package com.agasen.products.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.agasen.products.domain.Product;
import com.agasen.products.domain.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {

  private final ProductService productService;

  @GetMapping({ "/", "" })
  List<Product> getProducts(@RequestParam(required = false) String q) {
    if (q == null)
      return productService.getAllProducts();
    else
      return productService.getAllProductsContaining(q);
  }

  @GetMapping("/{id}")
  Product getProductById(@PathVariable("id") UUID id) {
    return productService.getProductById(id)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id of " + id + " was not found."));
  }

}
