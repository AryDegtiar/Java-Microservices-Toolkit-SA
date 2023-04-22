package com.sistemasactivos.monitoring.repository;

import java.io.Serializable;

import com.sistemasactivos.monitoring.model.Base;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.jpa.repository.JpaRepository;

@NoRepositoryBean
public interface BaseRepository<E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {
}
