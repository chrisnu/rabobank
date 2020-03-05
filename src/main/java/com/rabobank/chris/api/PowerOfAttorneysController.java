package com.rabobank.chris.api;

import com.rabobank.chris.api.exception.EntityNotFoundException;
import com.rabobank.chris.model.dto.PowerOfAttorneyDTO;
import com.rabobank.chris.model.dto.PowerOfAttorneyReferencesDTO;
import com.rabobank.chris.model.entities.PowerOfAttorney;
import com.rabobank.chris.service.PowerOfAttorneyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("power-of-attorneys")
@RestController
public class PowerOfAttorneysController {

    private final PowerOfAttorneyService powerOfAttorneyService;
    private final ModelMapper modelMapper;

    @Autowired
    public PowerOfAttorneysController(PowerOfAttorneyService powerOfAttorneyService, ModelMapper modelMapper) {
        this.powerOfAttorneyService = powerOfAttorneyService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<PowerOfAttorneyReferencesDTO> getPowerOfAttorneys() {
        return powerOfAttorneyService.findAll().stream()
                .map(poa -> modelMapper.map(poa, PowerOfAttorneyReferencesDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{id}")
    public PowerOfAttorneyDTO getPowerOfAttorney(@PathVariable("id") String id) {
        final PowerOfAttorney powerOfAttorney = powerOfAttorneyService
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, PowerOfAttorney.class));

        return modelMapper.map(powerOfAttorney, PowerOfAttorneyDTO.class);
    }
}
