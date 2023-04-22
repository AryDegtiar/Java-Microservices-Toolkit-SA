package com.api.sistemasactivos.costumer.service;

import com.api.sistemasactivos.costumer.interfaces.CostumerService;
import com.api.sistemasactivos.costumer.model.Costumer;
import com.api.sistemasactivos.costumer.repository.BaseRepository;
import com.api.sistemasactivos.costumer.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CostumerServiceImpl extends BaseServiceImpl<Costumer, Integer> implements CostumerService {
    public CostumerServiceImpl(BaseRepository<Costumer, Integer> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    private CostumerRepository costumerRepository;

    @Override
    @Transactional
    public Costumer save(Costumer entity) throws Exception {
        try {
            // por si se pone alguna fecha de creacion, con este metodo se pone la fecha actual actumaticamente
            Costumer costumer = new Costumer(entity.getDni(), entity.getFirstName(),
                    entity.getAge(), entity.getDatebirth(), entity.getEmail(), entity.getPhone());
            return costumerRepository.save(costumer);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Costumer update(Integer id, Costumer entity) throws Exception {
        try {
            Optional<Costumer> entityOptional = costumerRepository.findById(id);
            // utilizar el metodo actualizarCostumer de la clase Costumer para que ademas de actualizar se modifique la fecha de actualizacion
            entityOptional.get().actualizarCostumer(entity);
            return costumerRepository.save(entityOptional.get());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Page<Costumer> search(String keyword, Pageable pageable) throws Exception {
        try {
            return costumerRepository.search(keyword, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
