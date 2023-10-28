package edu.whu.demo;

import edu.whu.demo.entity.ProductItem;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Before
//    public void setUp() {
//        // 可以在这里进行一些初始化操作，如果有必要
//    }
//
//    @Test
//    public void testGetProduct() {
//        // 编写测试用例来测试获取商品的方法
//        ResponseEntity<ProductItem> response = restTemplate.getForEntity("/products/1", ProductItem.class);
//        assertThat(response.getStatusCodeValue()).isEqualTo(200); // 确保响应状态码为200
//        assertThat(response.getBody()).isNotNull(); // 确保响应主体不为空
//        // 进一步的断言，根据期望的响应进行检查
//    }
//
//    // 编写其他测试用例来测试增删改查等功能

}
