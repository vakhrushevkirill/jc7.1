package ru.netology.geo;

import ru.netology.entity.Location;
import ru.netology.geo.GeoService;

public class GeoServiceImplMock implements GeoService {
    @Override
    public Location byIp(String ip) {
        return null;
    }

    @Override
    public Location byCoordinates(double latitude, double longitude) {
        return null;
    }
}
