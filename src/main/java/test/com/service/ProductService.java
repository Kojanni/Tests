package test.com.service;

import test.com.model.Product;

import java.util.List;

public interface ProductService {
    Product findById(int id);

    List<Product> findAll();

    Product add(Product product);

    void deleteProduct(int productId);

    void updateProduct(Product product);

    int sumProductAmountByName(String name);
}
