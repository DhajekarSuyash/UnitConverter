package data.conversion.UnitConverter.massConversion;

import data.conversion.UnitConverter.dto.ConversionInput;
import data.conversion.UnitConverter.dto.ConversionOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/mass")
public class MassConverterController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private final MassConverterService massConverterService;

    public MassConverterController(MassConverterService massConverterService) {
        this.massConverterService = massConverterService;
    }

    @PostMapping("/convert")
    public ResponseEntity<ConversionOutput> getConvertedMass(@RequestBody ConversionInput conversionInput){
        ConversionOutput conversionOutput = massConverterService.startConversion(conversionInput);
        LOG.info("Conversion completed");
        return new ResponseEntity<>(conversionOutput, HttpStatus.OK);
    }

}
