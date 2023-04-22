package com.api.sistemasactivos.costumer.interfaces;

import com.api.sistemasactivos.costumer.model.Costumer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CostumerService extends BaseService<Costumer, Integer>{
    public Costumer update(Integer id, Costumer entity) throws Exception;
    public Page<Costumer> search(String keyword, Pageable pageable) throws Exception;

}