package com.haniffacateringbackend.api.service;

import com.haniffacateringbackend.api.model.Item;
import com.haniffacateringbackend.api.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll(Sort.by(Sort.Direction.DESC, "_id"));
    }

    public Item getItemById(String id) {
        return itemRepository.findById(id).orElseThrow();
    }

    public boolean deleteItem(String id) {
        if(!itemRepository.existsById(id)) {
            return false;
        }
        itemRepository.deleteById(id);
        return true;
    }
}