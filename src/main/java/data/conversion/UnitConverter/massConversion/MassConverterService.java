package data.conversion.UnitConverter.massConversion;

import data.conversion.UnitConverter.dto.ConversionInput;
import data.conversion.UnitConverter.dto.ConversionOutput;
import org.springframework.stereotype.Service;

@Service
public class MassConverterService {

    public ConversionOutput startConversion(ConversionInput conversionInput) {
        Double inputValue = conversionInput.getInputValue();
        Double output = inputValue * 1000;
        ConversionOutput conversionOutput = new ConversionOutput(conversionInput.getUserName(), conversionInput.getType(), output, conversionInput.getRequiredOutputUnit());
        return conversionOutput;
    }

}
