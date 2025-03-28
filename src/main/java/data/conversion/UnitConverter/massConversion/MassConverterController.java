package data.conversion.UnitConverter.massConversion;

import data.conversion.UnitConverter.dto.ConversionInput;
import data.conversion.UnitConverter.dto.ConversionOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/mass")
public class MassConverterController {

    @Autowired
    private MassConverterService massConverterService;

    @PostMapping("/convert")
    public ResponseEntity<ConversionOutput> getConvertedMass(@RequestBody ConversionInput conversionInput){
        System.err.println("Conversion input is : " + conversionInput.toString());
        ConversionOutput conversionOutput = massConverterService.startConversion(conversionInput);
        System.err.println("Conversion output is : " +conversionOutput.toString());
        return new ResponseEntity<ConversionOutput>(conversionOutput, HttpStatus.OK);
    }

}
