package com.vti.validation;

import com.vti.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryIdExistsValidation implements ConstraintValidator<CategoryIdExists, Integer> {
    @Autowired
    private ICategoryRepository repository;
    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        return repository.existsById(id);
    }
}
