package com.vti.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFilterForm {
    private String search;
    private String minprice;
    private String maxprice;
}
