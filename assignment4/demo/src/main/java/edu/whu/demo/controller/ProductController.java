package edu.whu.demo.controller;

import edu.whu.demo.entity.ProductItem;
import edu.whu.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductItem> getProduct(@PathVariable Long id) {
        ProductItem result = productService.getProduct(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ProductItem>> findProducts(@RequestParam(required = false) String name, @RequestParam(required = false) Boolean inStock) {
        List<ProductItem> result = productService.findProducts(name, inStock);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<ProductItem> addProduct(@RequestBody ProductItem product) {
        ProductItem result = productService.addProduct(product);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody ProductItem product) {
        productService.updateProduct(id, product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
