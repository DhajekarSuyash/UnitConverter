package data.conversion.UnitConverter.massConversion.entity;

import data.conversion.UnitConverter.constants.ConversionType;
import data.conversion.UnitConverter.constants.ConversionUnits;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class MassConversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;

    @Enumerated(EnumType.STRING)
    private ConversionType type;

    private double inputValue;

    @Enumerated(EnumType.STRING)
    private ConversionUnits inputUnit;

    private double outputValue;

    @Enumerated(EnumType.STRING)
    private ConversionUnits outputUnit;

}
