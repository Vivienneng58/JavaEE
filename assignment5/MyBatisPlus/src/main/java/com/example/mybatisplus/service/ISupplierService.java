package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.domain.Supplier;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiaxy
 * @since 2022-10-31
 */
public interface ISupplierService extends IService<Supplier> {

    IPage<Supplier> findSuppliers(String name, Integer pageNum, Integer pageSize);
}
