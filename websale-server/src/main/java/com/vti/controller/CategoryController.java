package com.vti.controller;

import com.vti.dto.CategoryDTO;
import com.vti.entity.Category;
import com.vti.form.CategoryCreateForm;
import com.vti.form.CategoryFilterForm;
import com.vti.form.CategoryUpdateForm;
import com.vti.service.ICategoryService;
import com.vti.validation.CategoryIdExists;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categorys")
@Validated
public class CategoryController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ICategoryService service;

    @GetMapping
    public Page<CategoryDTO> findAll(Pageable pageable, CategoryFilterForm form) {
        Page<Category> page = service.findAll(pageable, form);
        List<Category> categories = page.getContent();
        List<CategoryDTO> dtos = mapper.map(categories, new TypeToken<List<CategoryDTO>>(){}.getType());

        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }

    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable("id") @CategoryIdExists int id) {
        Category category = service.findById(id);
        CategoryDTO dto = mapper.map(category, CategoryDTO.class);
        return dto;
    }


    @PostMapping
    public void create(@RequestBody @Valid CategoryCreateForm form) {

        service.create(form);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") @CategoryIdExists  int id, @RequestBody CategoryUpdateForm form) {
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping
    public void deleteAllById(@RequestBody List<Integer> ids) {
        service.deleteAllById(ids);
    }

}
