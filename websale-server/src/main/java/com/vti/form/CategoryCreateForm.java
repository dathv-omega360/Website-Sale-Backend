package com.vti.form;

import com.vti.validation.CatogeryNameNotExists;
import com.vti.validation.ProductUsernameNotExists;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Getter
@Setter
public class CategoryCreateForm {
    @NotBlank(message = "Category name NotBlank")
    @Length(max = 50, message = "Category name has max 50 characters.")
    @CatogeryNameNotExists
    private String name;
    private String status;
    private List<@Valid Product> products;

    @Getter
    @Setter
    public static class Product {
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
    }


}
