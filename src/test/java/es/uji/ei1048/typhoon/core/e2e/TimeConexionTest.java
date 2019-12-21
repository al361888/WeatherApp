package es.uji.ei1048.typhoon.core.e2e;

import es.uji.ei1048.typhoon.core.ICurrentWeather;
import es.uji.ei1048.typhoon.core.TyphoonFacade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TimeConexionTest {

    private TyphoonFacade sut;


    @Before
    public void setUp() throws Exception {
        sut = new TyphoonFacade(mock(ICurrentWeather.class));
    }

    @After
    public void tearDown() throws Exception {
        sut = null;

    }

    @Test
    public void currentWeatherCityCallServer(){

    }

    @Test
    public void currentWeatherCoordCallServer(){

    }

    @Test
    public void currentWeatherCityBBDD(){

    }

    @Test
    public void currentWeatherCoordBBDD(){

    }


}