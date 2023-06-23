package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CategoryDTO {
    private Integer id;
    private String name;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;
    private List<ProductDTO> products;

    @Getter
    @Setter
    public static class  ProductDTO{
        @JsonProperty("tId")
        private Integer id;
        private String name;
    }

}
