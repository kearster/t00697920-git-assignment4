package conversions;

public class CelsiusToKelvinConverter extends TemperatureConverter{
    public CelsiusToKelvinConverter() {
        super(TemperatureUnit.CELSIUS, TemperatureUnit.KELVIN);
    }

    @Override
    public double convert(double celsius) {
        return celsius+273.15;
    }
}
