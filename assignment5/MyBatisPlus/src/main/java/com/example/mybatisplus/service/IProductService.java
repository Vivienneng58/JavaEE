package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mybatisplus.domain.Product;
import com.example.mybatisplus.domain.ProductDTO;
import com.example.mybatisplus.domain.Supplier;
import com.example.mybatisplus.exception.ProductAdminException;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiaxy
 * @since 2022-10-31
 */
public interface IProductService extends IService<Product> {

    IPage<ProductDTO> findProduct(Map<String, Object> condition, Integer pageNum, Integer pageSize);

    Product addProduct(Product product) throws ProductAdminException;

    void updateProduct(long id, Product product) throws ProductAdminException;

    void updateProductSuppliers(long id, List<Supplier> suppliers) throws ProductAdminException;

    void deleteProduct(long id) throws ProductAdminException;
}
