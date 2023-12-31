package com.vti.validation;

import com.vti.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryNameNotExistValidation implements ConstraintValidator<CatogeryNameNotExists, String> {
    @Autowired
    private ICategoryRepository repository;
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByName(name);
    }
}
