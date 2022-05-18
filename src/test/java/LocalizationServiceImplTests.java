import org.junit.jupiter.api.*;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizationServiceImplTests {
    private LocalizationServiceImpl sut;
    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new LocalizationServiceImpl();
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
    @Test
    public void testByIp(){
        //arrange
        String expected = "Добро пожаловать";
        //act
        String result = sut.locale(Country.RUSSIA);
        //assert
        assertEquals(expected, result);
    }
}

