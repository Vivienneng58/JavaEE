package edu.whu.demo.service;

import edu.whu.demo.entity.ProductItem;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    // 创建线程安全的map，模拟商品信息的存储
    private Map<Long, ProductItem> products = Collections.synchronizedMap(new HashMap<Long, ProductItem>());
    private long nextId = 1;

    public ProductItem addProduct(ProductItem product) {
        product.setId(nextId);
        products.put(nextId, product);
        nextId++;
        return product;
    }

    public ProductItem getProduct(Long id) {
        return products.get(id);
    }

    public List<ProductItem> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public List<ProductItem> findProducts(String name, Boolean inStock) {
        List<ProductItem> result = new ArrayList<>();
        for (ProductItem product : products.values()) {
            if (name != null && !product.getName().contains(name)) continue;
            if (inStock != null && inStock != (product.getQuantity() > 0)) continue;
            result.add(product);
        }
        return result;
    }

    public void updateProduct(Long id, ProductItem updatedProduct) {
        ProductItem product = products.get(id);
        if (product != null) {
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setQuantity(updatedProduct.getQuantity());
            products.put(id, product);
        }
    }

    public boolean deleteProduct(Long id) {
        ProductItem product = products.remove(id);
        return product != null;
    }

}
