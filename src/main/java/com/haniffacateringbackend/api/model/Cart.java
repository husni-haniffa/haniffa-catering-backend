package com.haniffacateringbackend.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends Item{
    private int quantity;
    private int subTotal;
}
