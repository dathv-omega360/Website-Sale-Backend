package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductDTO {
    private Integer Id;
    private String name;
    private String description;
    private String thumbnailUrl;
    private Double quantity;
    private Double soldQuantity;
    private Double price;
    private Double salePrice;
    private Boolean status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;
    private String categoryName;
}
