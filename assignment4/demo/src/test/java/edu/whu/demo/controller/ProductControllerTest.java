package edu.whu.demo.controller;

import edu.whu.demo.entity.ProductItem;
import edu.whu.demo.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductService productService;

    @Before
    public void setUp() {
        // 可以在这里初始化一些测试数据
        ProductItem product = new ProductItem();
        product.setName("Test Product");
        product.setPrice(10.0);
        product.setQuantity(5);
        productService.addProduct(product);
    }

    @Test
    public void testGetProduct() {
        ResponseEntity<ProductItem> response = restTemplate.getForEntity("/products/1", ProductItem.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("Test Product");
    }

    @Test
    public void testAddProduct() {
        ProductItem newProduct = new ProductItem();
        newProduct.setName("New Product");
        newProduct.setPrice(15.0);
        newProduct.setQuantity(10);

        ResponseEntity<ProductItem> response = restTemplate.postForEntity("/products", newProduct, ProductItem.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();
    }

    @Test
    public void testDeleteProduct() {
        ResponseEntity<Void> response = restTemplate.exchange("/products/1", HttpMethod.DELETE, null, Void.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(204);

        // Verify that the product has been deleted
        ProductItem deletedProduct = productService.getProduct(1L);
        assertThat(deletedProduct).isNull();
    }
}
