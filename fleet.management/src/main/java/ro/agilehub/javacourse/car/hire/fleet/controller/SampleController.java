package ro.agilehub.javacourse.car.hire.fleet.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.agilehub.javacourse.car.hire.api.model.SampleDTO;
import ro.agilehub.javacourse.car.hire.api.specification.SampleApi;

import java.util.Collections;
import java.util.List;

@RestController
public class SampleController implements SampleApi {

    @Override
    public ResponseEntity<List<SampleDTO>> getSamples() {
        SampleDTO sampleDTO = new SampleDTO();
        sampleDTO.setId(1);
        sampleDTO.setName("My first sample");
        return ResponseEntity.ok(Collections.singletonList(sampleDTO));
    }
}
