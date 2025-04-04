package data.conversion.UnitConverter.massConversion;

import data.conversion.UnitConverter.constants.ConversionType;
import data.conversion.UnitConverter.constants.ConversionUnits;
import data.conversion.UnitConverter.dto.ConversionInput;
import data.conversion.UnitConverter.dto.ConversionOutput;
import data.conversion.UnitConverter.massConversion.entity.MassConversion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MassConverterService {

    private final Logger LOG = LoggerFactory.getLogger(MassConverterService.class);
    private final MassConverterExecutor executor;

    private final MassConverterRepository repository;

    public MassConverterService(MassConverterExecutor executor, MassConverterRepository repository) {
        this.executor = executor;
        this.repository = repository;
    }

    public ConversionOutput startConversion(ConversionInput conversionInput) {
        String inputUnit = conversionInput.getInputUnit().toString();
        String reqOutputUnit = conversionInput.getRequiredOutputUnit().toString();
        String command = createMassConversionCommand(inputUnit, reqOutputUnit);
        LOG.info("Conversion command executed : " +command);
        double outputValue = executor.massConverter(conversionInput.getInputValue(), command);
        storeConversionInDb(conversionInput, outputValue);
        LOG.info("Conversion stored to database ");
        return createConversionOutput(conversionInput.getUserName(), conversionInput.getType(), outputValue, conversionInput.getRequiredOutputUnit());
    }

    private String createMassConversionCommand(String inputUnit, String outputUnit) {
        return inputUnit + "To" + outputUnit;
    }

    private ConversionOutput createConversionOutput(String username, ConversionType type, double outputValue, ConversionUnits outputUnit) {
        return new ConversionOutput(username, type, outputValue, outputUnit);
    }

    private void storeConversionInDb(ConversionInput conversionInput, double outputValue) {

        MassConversion massConversion = new
                MassConversion(0, conversionInput.getUserName(), conversionInput.getType(),
                conversionInput.getInputValue(), conversionInput.getInputUnit(), outputValue,
                conversionInput.getRequiredOutputUnit());
        try {
            repository.save(massConversion);
        } catch (Exception e) {
            LOG.error("Exception in storing conversion to database "+e);
        }


    }

}
