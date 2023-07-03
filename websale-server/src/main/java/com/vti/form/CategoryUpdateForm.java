package com.vti.form;

import com.vti.validation.CatogeryNameNotExists;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CategoryUpdateForm {
    private Integer id;
    @NotBlank(message = "Category name NotBlank")
    @Length(max = 50, message = "Category name has max 50 characters.")
    @CatogeryNameNotExists
    private String name;
    private String status;
}
