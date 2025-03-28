package data.conversion.UnitConverter.dto;

import data.conversion.UnitConverter.constants.ConversionType;
import data.conversion.UnitConverter.constants.ConversionUnits;
import lombok.*;

@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
public class ConversionInput {

    private String userName;

    private ConversionType type;

    private double inputValue;

    private ConversionUnits inputUnit;

    private ConversionUnits requiredOutputUnit;
}
