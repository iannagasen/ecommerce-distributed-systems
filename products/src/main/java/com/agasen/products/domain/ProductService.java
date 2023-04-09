package com.agasen.products.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public List<Product> getAllProductsContaining(String name) {
    return productRepository.findByNameContainingIgnoreCase(name);
  }

  public Optional<Product> getProductById(UUID id) {
    return productRepository.findById(id);
  }
}
