package com.cinelist.ms.cast.services.register.impl;

import com.cinelist.ms.cast.database.models.Occupation;
import com.cinelist.ms.cast.database.repositories.OccupationRepository;
import com.cinelist.ms.cast.dtos.occupations.OccupationRequest;
import com.cinelist.ms.cast.services.register.OccupationRegisterService;
import org.springframework.stereotype.Service;

@Service
public class OccupationRegisterServiceImpl implements OccupationRegisterService {
    private final OccupationRepository occupationRepository;

    public OccupationRegisterServiceImpl(OccupationRepository occupationRepository) {
        this.occupationRepository = occupationRepository;
    }

    @Override
    public Occupation register(OccupationRequest request) {
        Occupation occupation = new Occupation(request.name());

        return occupationRepository.save(occupation);
    }
}