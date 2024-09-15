package com.cloth.BF.Utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int id;
    private String name;

    private Double price;

    private String colour;

    private String description;

    private String brand;

    private int quantity;

}
