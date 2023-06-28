package com.vti.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreateForm {
    private String name;
    private String description;
    private String thumbnailUrl;
    private Double quantity;
    private Double soldQuantity;
    private Double price;
    private Double salePrice;
    private Boolean status;
    private Integer categoryId;

}
