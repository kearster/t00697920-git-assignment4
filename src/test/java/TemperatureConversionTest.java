import conversions.CelsiusToFahrenheitConverter;
import conversions.CelsiusToKelvinConverter;
import conversions.FahrenheitToCelsiusConverter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
public class TemperatureConversionTest {

    private final ByteArrayOutputStream testOutputStream = new ByteArrayOutputStream();
    private final PrintStream originalSystemOutput = System.out;
    private final double DELTA = 0.01;

    @Before
    public void createStream() {
        System.setOut(new PrintStream(testOutputStream));
    }

    @After
    public void returnOriginalStream() {
        System.setOut(originalSystemOutput);
    }

    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(212, new CelsiusToFahrenheitConverter().convert(100), DELTA);
    }

    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(295, new FahrenheitToCelsiusConverter().convert(563), DELTA);
    }

    @Test
    public void testCelsiusToKelvin() {
        assertEquals(473.15, new CelsiusToKelvinConverter().convert(200), DELTA);
    }

    @Test
    public void testDoubleInput() {
        String values = "10.5 dsfo 30"; // Input given to the method
        Scanner scanner = new Scanner(values);
        assertEquals(10.5, TempConvProgramRefactored.getConversionInput(scanner, ""), 0);
        // Get error message and the value finally evaluated.
        double conversion = TempConvProgramRefactored.getConversionInput(scanner, "");
        assertEquals("Invalid input, try again!\r", testOutputStream.toString().split("\n")[2]);
        assertEquals(30, conversion, 0);
    }
}
