package com.haniffacateringbackend.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "order_summary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderSummary {
    private String id;
    private Map<String, Integer> itemCounts = new HashMap<>();
}
