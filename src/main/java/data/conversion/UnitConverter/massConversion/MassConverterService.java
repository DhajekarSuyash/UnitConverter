package data.conversion.UnitConverter.massConversion;

import data.conversion.UnitConverter.constants.ConversionType;
import data.conversion.UnitConverter.constants.ConversionUnits;
import data.conversion.UnitConverter.dto.ConversionInput;
import data.conversion.UnitConverter.dto.ConversionOutput;
import data.conversion.UnitConverter.operations.MultiplicationFactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MassConverterService {


    private MassConverterExecutor executor;

    public MassConverterService(MassConverterExecutor executor) {
        this.executor = executor;
    }

    public ConversionOutput startConversion(ConversionInput conversionInput) {
       String inputUnit =  conversionInput.getInputUnit().toString();
        String reqOutputUnit = conversionInput.getRequiredOutputUnit().toString();
        String command = createMassConversionCommand(inputUnit,reqOutputUnit);
        double outputValue = executor.massConverter(conversionInput.getInputValue() , command);
        System.err.println("Output : " +outputValue);
        return createConversionOutput(conversionInput.getUserName(), conversionInput.getType(), outputValue, conversionInput.getRequiredOutputUnit());
    }

    private String createMassConversionCommand(String inputUnit , String outputUnit){
        return inputUnit+"To"+outputUnit;
    }

    private ConversionOutput createConversionOutput(String username , ConversionType type , double outputValue , ConversionUnits outputUnit){
        return new ConversionOutput(username,type,outputValue,outputUnit);
    }

}
