package com.rabobank.chris.api;

import com.rabobank.chris.model.entities.PowerOfAttorney;
import com.rabobank.chris.model.PowerOfAttorneyReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("power-of-attorneys")
@RestController
public class PowerOfAttorneysController {

    public PowerOfAttorneysController() {
    }

    @GetMapping
    public List<PowerOfAttorneyReference> getPowerOfAttorneys() {
        var ref1 = new PowerOfAttorneyReference();
        ref1.setId("0001");
        var ref2 = new PowerOfAttorneyReference();
        ref2.setId("0002");

        var list = new ArrayList<PowerOfAttorneyReference>();
        list.add(ref1);
        list.add(ref2);

        return list;
    }

    @GetMapping(path = "{id}")
    public PowerOfAttorney getPowerOfAttorney(@PathVariable("id") String id) {
        var p = new PowerOfAttorney();
//        p.setId(id);
        return p;
    }
}
