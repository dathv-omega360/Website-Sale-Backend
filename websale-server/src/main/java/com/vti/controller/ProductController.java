package com.vti.controller;

import com.vti.dto.ProductDTO;
import com.vti.entity.Product;
import com.vti.form.ProductCreateForm;
import com.vti.form.ProductFilterForm;
import com.vti.form.ProductUpdateForm;
import com.vti.service.IProductService;
import com.vti.validation.ProductIdExists;
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
@RequestMapping("/api/v1/products")
@Validated
public class ProductController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IProductService service;

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable, ProductFilterForm form){
        Page<Product> page = service.findAll(pageable, form);
        List<Product> products = page.getContent();
        List<ProductDTO> dtos = mapper.map(products, new TypeToken<List<ProductDTO>>(){}.getType());
        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable("id") @ProductIdExists int id){
        Product product = service.findById(id);
        ProductDTO dto = mapper.map(product, ProductDTO.class);
        return dto;
    }

    @PostMapping
    public void create(@RequestBody @Valid ProductCreateForm form){
        service.create(form);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") @ProductIdExists int id, @RequestBody ProductUpdateForm form){
        form.setId(id);
        service.update(form);
    }
    @DeleteMapping
    public void deleteAllByIdInBatch(@RequestBody List<Integer> ids){

        service.deleteAllById(ids);
    }

}
