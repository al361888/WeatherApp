package es.uji.ei1048.typhoon.core.e2e;

import es.uji.ei1048.typhoon.core.*;
import es.uji.ei1048.typhoon.weather.WeatherStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CurrentWeatherCoordinatesTest {

    private TyphoonFacade sut;
    private WeatherStatus ws;

    @Rule
    public final ExpectedException ex = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        sut = new TyphoonFacade();
        ws = new WeatherStatus();
    }

    @After
    public void tearDown() throws Exception {
        sut = null;
        ws = null;
    }

    @Test
    public void currentWeatherCity_valid() throws InvalidCoordinatesException {
        //Given
        Coordinates coord = new Coordinates(10, -10);
        //When
        WeatherStatus status = sut.currentWeatherCoordinates(coord);
        //Then
        assertNotEquals(ws, status);
    }

    @Test(expected = NullPointerException.class)
    public void currentWeatherCity_invalid() throws InvalidCoordinatesException {
        //Given
        Coordinates coord = new Coordinates(100000, -1000000);
        //When
        WeatherStatus status = sut.currentWeatherCoordinates(coord);
        //Then Salta NoCityFoundException
    }
}