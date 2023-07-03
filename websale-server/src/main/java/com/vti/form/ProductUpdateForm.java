package com.vti.form;

import com.vti.validation.ProductUsernameNotExists;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
public class ProductUpdateForm {
    private Integer id;
    @NotBlank(message = "Product name NotBlank")
    @Length(max = 50, message = "Product name has max 50 characters.")
    @ProductUsernameNotExists
    private String name;
    private String description;
    private String thumbnailUrl;
    private Double quantity;
    private Double soldQuantity;
    @PositiveOrZero(message = "Product price must be greatr than or equal to 0.")
    @NotNull(message = "Product price must be NOT null.")
    private Double price;
    private Double salePrice;
    private Boolean status;
    private Integer categoryId;
}
