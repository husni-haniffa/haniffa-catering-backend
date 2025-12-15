package com.haniffacateringbackend.api.repository;

import com.haniffacateringbackend.api.model.OrderSummary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSummaryRepository extends MongoRepository<OrderSummary, String> {
}
