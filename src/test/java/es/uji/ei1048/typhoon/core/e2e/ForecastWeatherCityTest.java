package es.uji.ei1048.typhoon.core.e2e;

import es.uji.ei1048.typhoon.core.City;
import es.uji.ei1048.typhoon.core.NoCityFoundException;
import es.uji.ei1048.typhoon.core.TyphoonFacade;
import es.uji.ei1048.typhoon.weather.WeatherStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

public class ForecastWeatherCityTest {
    private TyphoonFacade sut;
    private List<WeatherStatus> ws;

    @Rule
    public final ExpectedException ex = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        sut = new TyphoonFacade();
        ws = new ArrayList<WeatherStatus>();
    }

    @After
    public void tearDown() throws Exception {
        sut = null;
        ws = null;
    }

    @Test
    public void forecastWeatherCity_valid() throws NoCityFoundException, UnsupportedEncodingException, MalformedURLException {
        //Given
        City city = new City("Valencia");
        //When
        List<WeatherStatus> status = sut.forecastWeatherCity(city);
        //Then
        assertNotEquals(ws, status);
    }

    @Test(expected = NullPointerException.class)
    public void forecastWeatherCity_invalid() throws NoCityFoundException, UnsupportedEncodingException, MalformedURLException {
        //Given
        City city = new City("Minas Tirith");
        //When
        List<WeatherStatus> status = sut.forecastWeatherCity(city);
        //Then Salta NoCityFoundException
    }
}