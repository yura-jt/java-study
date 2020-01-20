package com.javacourse.task1_2;

public enum SolarSystem {
    MERCURY("Me", 0x263F),
    VENUS("V", 0x2640),
    EARTH("E", 0x1F728),
    MARS("Ma", 0x2642),
    JUPITER("J", 0x2643),
    SATURN("S", 0x2644),
    URANUS("U", 0x2645),
    NEPTUNE("N", 0x2BC9);

    private final String astroPlanetCode;
    private final int symbolUnicodeNumber;

    SolarSystem(String planetAstroCode, int symbolUnicodeNumber) {
        this.astroPlanetCode = planetAstroCode;
        this.symbolUnicodeNumber = symbolUnicodeNumber;
    }

    public String getPlanetAstroCode() {
        return astroPlanetCode;
    }

    public int getSymbolUnicodeNumber() {
        return symbolUnicodeNumber;
    }
}
