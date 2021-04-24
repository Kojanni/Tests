package test.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.com.model.Product;
import test.com.repository.ProductRepository;
import test.com.service.ProductService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found by id"));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public int sumProductAmountByName(String name) {
        Integer sum = productRepository.sumAmountByName(name);

        if (sum != null) {
            return sum.intValue();
        }
        return -1;
    }
}
