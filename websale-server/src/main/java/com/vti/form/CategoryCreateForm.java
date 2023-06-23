package com.vti.form;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
public class CategoryCreateForm {
    private String name;
    private String status;
    private List<Product> products;

    @Getter
    @Setter
    public static class  Product{
        private String name;
        private String description;
        private String thumbnailUrl;
        private Double quantity;
        private Double soldQuantity;
        private Double price;
        private Boolean status;
    }


}
