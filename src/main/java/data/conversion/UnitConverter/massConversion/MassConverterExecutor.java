package data.conversion.UnitConverter.massConversion;

import data.conversion.UnitConverter.operations.DivisonFactor;
import data.conversion.UnitConverter.operations.MultiplicationFactor;
import org.springframework.stereotype.Service;

@Service
public class MassConverterExecutor {

    public double massConverter(double inputValue , String command){
    double op = switch (command) {
        //one-step conversions
        case "KilogramToGrams" -> MultiplicationFactor.multiplyByThousand(inputValue);
        case "GramsToCentigrams" -> MultiplicationFactor.multiplyByHundred(inputValue);
        case "CentigramsToMilligrams" -> MultiplicationFactor.multiplyByTen(inputValue);
        case "MilligramsToCentigrams" -> DivisonFactor.divideByTen(inputValue);
        case "CentigramsToGrams" -> DivisonFactor.divideByHundred(inputValue);
        case "GramsToKilogram" -> DivisonFactor.divideByThousand(inputValue);
        //two-step conversions
        case "KilogramToCentigrams" -> MultiplicationFactor.multiplyByHundreadThousand(inputValue);
        case "GramsToMilligrams" -> MultiplicationFactor.multiplyByThousand(inputValue);
        case "MilligramsToGrams" -> DivisonFactor.divideByThousand(inputValue);
        case "CentigramsToKilogram"->DivisonFactor.divideByHundreadThousand(inputValue);
        //three-step conversion
        case "KilogramToMilligrams" ->0;
        case "MilligramsToKilogram" -> 0;
        default -> 0;
    };
        return op;
    }

}
