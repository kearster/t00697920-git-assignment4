package conversions;

public abstract class TemperatureConverter {

    private TemperatureUnit convertsFrom;
    private TemperatureUnit convertsTo;

    public TemperatureConverter(TemperatureUnit convertsFrom, TemperatureUnit convertsTo) {
        this.convertsFrom = convertsFrom;
        this.convertsTo = convertsTo;
    }

    public String getDescription() {
        return String.format("Converts %s to %s", convertsFrom.name().toLowerCase(), convertsTo.name().toLowerCase());
    }
    abstract public double convert(double temperature);

    public TemperatureUnit getConvertsFrom() {
        return convertsFrom;
    }

    public TemperatureUnit getConvertsTo() {
        return convertsTo;
    }
}
