package com.api.sistemasactivos.costumer.repository;

import com.api.sistemasactivos.costumer.model.Costumer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostumerRepository extends BaseRepository<Costumer, Integer>{
    @Query("SELECT c FROM Costumer c WHERE c.firstName LIKE %:keyword% OR c.email LIKE %:keyword% OR c.phone LIKE %:keyword%")
    public Page<Costumer> search(@Param("keyword") String keyword, Pageable pageable);
}
