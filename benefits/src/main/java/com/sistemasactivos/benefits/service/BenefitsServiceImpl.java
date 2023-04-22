package com.sistemasactivos.benefits.service;

import com.sistemasactivos.benefits.interfaces.BenefitsService;
import com.sistemasactivos.benefits.model.Benefits;
import com.sistemasactivos.benefits.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class BenefitsServiceImpl extends BaseServiceImpl<Benefits, Integer> implements BenefitsService {
    public BenefitsServiceImpl(BaseRepository<Benefits, Integer> baseRepository) {
        super(baseRepository);
    }
}
