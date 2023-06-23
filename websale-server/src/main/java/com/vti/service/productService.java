package com.vti.service;

import com.vti.entity.Product;
import com.vti.form.ProductCreateForm;
import com.vti.form.ProductFilterForm;
import com.vti.form.ProductUpdateForm;
import com.vti.repository.ICategoryRepository;
import com.vti.repository.IProductRepository;
import com.vti.specification.ProductSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService implements IProductService{
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IProductRepository repository;

    @Override
    public Page<Product> findAll(Pageable pageable, ProductFilterForm form) {
        Specification spec = ProductSpecification.builSpec(form);
        return repository.findAll(spec, pageable);
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(ProductCreateForm form) {
        Product account = mapper.map(form, Product.class);
        repository.save(account);

    }

    @Override
    public void update(ProductUpdateForm form) {
        Product account = mapper.map(form, Product.class);
        repository.save(account);

    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        repository.deleteAllById(ids);

    }
}
