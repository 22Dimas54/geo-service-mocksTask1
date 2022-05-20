package ru.netology.geo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeoServiceImplTests {
    private GeoServiceImpl sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new GeoServiceImpl();
    }

    @BeforeAll
    public static void started() {
        System.out.println("tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("\ntest compiled");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("tests finished");
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testByIp(String ip) {
        //arrange
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        //act
        Location result = sut.byIp(ip);
        //assert
        assertEquals(expected.getCity(), result.getCity());
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of("172.123.12.19"), Arguments.of("172.555.12.19"), Arguments.of("172.777.88.99"));
    }

    @ParameterizedTest
    @MethodSource("sourceByCoordinates")
    public void byCoordinates(double latitude, double longitude) {
        assertThrows(RuntimeException.class, () -> sut.byCoordinates(latitude, longitude));
    }

    private static Stream<Arguments> sourceByCoordinates() {
        return Stream.of(Arguments.of(1.2, 1.5), Arguments.of(77, 99.5), Arguments.of(8.2, 1.7));
    }
}
