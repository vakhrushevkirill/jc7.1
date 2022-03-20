package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @Test
    void byIpMock() {
        String ip = "127.0.0.1";
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Location location = new Location("Moscow", Country.RUSSIA, "Tatarskaya", 1);
        Mockito.when(geoService.byIp(ip)).thenReturn(location);
        Assertions.assertEquals(location, geoService.byIp(ip));
    }

    @Test
    void byIp() {

    }
}