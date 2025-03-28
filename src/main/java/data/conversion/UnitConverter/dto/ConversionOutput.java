package data.conversion.UnitConverter.dto;

import data.conversion.UnitConverter.constants.ConversionType;
import data.conversion.UnitConverter.constants.ConversionUnits;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@ToString
public class ConversionOutput {
    private String username;

    private ConversionType type;

    private double outputValue;

    private ConversionUnits outputUnit;


}
