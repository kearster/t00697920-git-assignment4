package conversions;

public class CelsiusToFahrenheitConverter extends TemperatureConverter {

    public CelsiusToFahrenheitConverter() {
        super(TemperatureUnit.CELSIUS, TemperatureUnit.FAHRENHEIT);
    }

    @Override
    public double convert(double celsius) {
        return celsius*9/5+32;
    }
}
