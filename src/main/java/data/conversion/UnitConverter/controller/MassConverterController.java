package data.conversion.UnitConverter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/mass")
public class MassConverterController {

    @GetMapping("/convert")
    public ResponseEntity<String> getConvertedMass(){

        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
