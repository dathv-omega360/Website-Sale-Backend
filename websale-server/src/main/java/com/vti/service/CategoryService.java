package com.vti.service;

import com.vti.entity.Category;
import com.vti.form.CategoryCreateForm;
import com.vti.form.CategoryFilterForm;
import com.vti.form.CategoryUpdateForm;
import com.vti.repository.ICategoryRepository;
import com.vti.specification.CategorySpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ICategoryRepository repository;


    @Override
    public Page<Category> findAll(Pageable pageable, CategoryFilterForm form) {
        Specification<Category> spec = CategorySpecification.buildSpec(form);
        return repository.findAll(spec, pageable);
    }

    @Override
    public Category findById(int id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(CategoryCreateForm form) {
        Category category = mapper.map(form, Category.class);
        repository.save(category);

    }

    @Override
    public void update(CategoryUpdateForm form) {
        Category category = mapper.map(form, Category.class);
        repository.save(category);

    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        repository.deleteAllById(ids);
    }
}
