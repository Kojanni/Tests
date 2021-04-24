package test.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.com.model.Product;
import test.com.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("")
    public ResponseEntity<Product> getProduct(@RequestParam int id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok( productService.add(product));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteProduct(@RequestParam int id) {
       productService.deleteProduct(id);

        return ResponseEntity.ok(true);
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);

        return ResponseEntity.ok(true);
    }

    @GetMapping("/amount")
    public ResponseEntity<Integer> productAmountByName(@RequestParam String name) {
        return  ResponseEntity.ok(productService.sumProductAmountByName(name));
    }
}
