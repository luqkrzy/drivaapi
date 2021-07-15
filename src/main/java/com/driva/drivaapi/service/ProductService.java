package com.driva.drivaapi.service;

import com.driva.drivaapi.mapper.dto.ProductDTO;
import com.driva.drivaapi.model.product.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    ProductDTO save(ProductDTO product);
}
