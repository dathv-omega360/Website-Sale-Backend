package com.vti.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateForm {
    private Integer id;
    private String name;
    private String description;
    private String thumbnailUrl;
    private Double quantity;
    private Double soldQuantity;
    private Double price;
    private Boolean status;
    private Integer categoryId;
}
