package com.vti.validation;

import com.vti.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductUsernameNotExistsValidator implements ConstraintValidator<ProductUsernameNotExists, String> {
    @Autowired
    private IProductRepository repository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return repository.existsByUsername(username);
    }
}
