package com.haniffacateringbackend.api.repository;

import com.haniffacateringbackend.api.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
}
