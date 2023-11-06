package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.dao.SupplierDao;
import com.example.mybatisplus.domain.Supplier;
import com.example.mybatisplus.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiaxy
 * @since 2022-10-31
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierDao, Supplier> implements ISupplierService {

    @Override
    public IPage<Supplier> findSuppliers(String name, Integer pageNum, Integer pageSize) {
        Page<Supplier> page=new Page<>(pageNum,pageSize);
        QueryWrapper<Supplier> qw = new QueryWrapper<>();
        qw.like(name!=null,"name",name);
        this.baseMapper.selectPage(page,qw);
        return page;
    }

}
