package edu.whu.demo.service;

import edu.whu.demo.entity.ProductItem;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductServiceTest {
    private ProductService productService;

    @Before
    public void setUp() {
        productService = new ProductService();
        ProductItem product = new ProductItem();
        product.setName("Test Product");
        product.setPrice(10.0);
        product.setQuantity(5);
        productService.addProduct(product);
    }

    @Test
    public void testGetProduct() {
        ProductItem product = productService.getProduct(1L);
        assertThat(product).isNotNull();
        assertThat(product.getName()).isEqualTo("Test Product");
    }

    @Test
    public void testAddProduct() {
        ProductItem newProduct = new ProductItem();
        newProduct.setName("New Product");
        newProduct.setPrice(15.0);
        newProduct.setQuantity(10);

        ProductItem addedProduct = productService.addProduct(newProduct);
        assertThat(addedProduct).isNotNull();
        assertThat(addedProduct.getId()).isNotNull();
    }

    @Test
    public void testDeleteProduct() {
        boolean deleted = productService.deleteProduct(1L);
        assertThat(deleted).isTrue();

        // Verify that the product has been deleted
        ProductItem deletedProduct = productService.getProduct(1L);
        assertThat(deletedProduct).isNull();
    }
}
