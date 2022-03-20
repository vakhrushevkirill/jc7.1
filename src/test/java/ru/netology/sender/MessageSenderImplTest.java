package ru.netology.sender;

import ru.netology.i18n.LocalizationServiceImplMock;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {
    @Test
    void test_ru_ip(){
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Location location = new Location("Moscow", Country.RUSSIA, null, 0);
        Mockito.when(geoService.byIp("172.123.12.19")).thenReturn(location);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        Assertions.assertEquals("Добро пожаловать", messageSender.send(headers));

    }

    @Test
    void test_en_ip(){
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Location location = new Location("New York", Country.USA, " 10th Avenue", 32);
        Mockito.when(geoService.byIp("96.44.183.149")).thenReturn(location);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        Map<String, String> headers = new HashMap<String, String>();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        Assertions.assertEquals("Welcome", messageSender.send(headers));
    }
}