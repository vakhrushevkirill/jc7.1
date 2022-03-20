package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void test_local_service(){
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);
        Assertions.assertEquals("Добро пожаловать", localizationService.locale(Country.RUSSIA));
        Assertions.assertNotEquals("Welcome", localizationService.locale(Country.RUSSIA));
    }

    @Test
    void test_local_service_mock(){
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImplMock.class);
        Assertions.assertNotEquals("Добро пожаловать", localizationService.locale(Country.GERMANY));
    }
}