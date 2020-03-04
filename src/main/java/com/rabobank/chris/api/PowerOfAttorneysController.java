package com.rabobank.chris.api;

import com.rabobank.chris.api.exception.EntityNotFoundException;
import com.rabobank.chris.model.entities.PowerOfAttorney;
import com.rabobank.chris.service.PowerOfAttorneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("power-of-attorneys")
@RestController
public class PowerOfAttorneysController {

    private PowerOfAttorneyService powerOfAttorneyService;

    @Autowired
    public PowerOfAttorneysController(PowerOfAttorneyService powerOfAttorneyService) {
        this.powerOfAttorneyService = powerOfAttorneyService;
    }

    @GetMapping
    public List<PowerOfAttorney> getPowerOfAttorneys() {
        return this.powerOfAttorneyService.findAll();
    }

    @GetMapping(path = "{id}")
    public PowerOfAttorney getPowerOfAttorney(@PathVariable("id") String id) {
        return this.powerOfAttorneyService
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, PowerOfAttorney.class));
    }
}
