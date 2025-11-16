package conversions;

public class FahrenheitToCelsiusConverter extends TemperatureConverter {

    public FahrenheitToCelsiusConverter() {
        super(TemperatureUnit.FAHRENHEIT, TemperatureUnit.CELSIUS);
    }

    @Override
    public double convert(double fahrenheit) {
        return (fahrenheit-32)*5/9;
    }
}
