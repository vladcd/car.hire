package ro.agilehub.javacourse.car.hire.fleet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.agilehub.javacourse.car.hire.api.model.SampleDTO;
import ro.agilehub.javacourse.car.hire.api.specification.SampleApi;
import ro.agilehub.javacourse.car.hire.fleet.service.SampleService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class SampleController implements SampleApi {

    @Autowired
    private SampleService sampleService;

    @Override
    public ResponseEntity<List<SampleDTO>> getSamples() {
        var sampleEntities = sampleService.findAll();
        return ResponseEntity.ok(sampleEntities.stream()
                .map(sampleEntity -> {
                    var result = new SampleDTO();
                    result.setId(sampleEntity.getId());
                    result.setName(sampleEntity.getName() + " " + sampleEntity.getCountry().getName());
                    return result;
                })
                .collect(toList()));
    }
}
