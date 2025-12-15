package com.haniffacateringbackend.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order_summary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderSummary {
    private String id;
    private int chickenBiriyani;
    private int beefBiriyani;
    private int muttonBiriyani;
    private int chicken;
    private int exChicken;
    private int exWattalapam;
}
