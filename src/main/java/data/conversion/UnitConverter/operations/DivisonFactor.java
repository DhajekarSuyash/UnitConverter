package data.conversion.UnitConverter.operations;

public class DivisonFactor {

    public static double divideByTen(double inputValue){
        return inputValue/10.0;
    }

    public static double divideByHundred(double inputValue){
        return inputValue/100.0;
    }

    public static double divideByThousand(double inputValue){
        return inputValue/1000.0;
    }

    public static double divideByHundreadThousand(double inputValue) {
        return inputValue / 100000.0;
    }
}
