import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void findAgeGroup() {
        Main main = new Main();
        assertAll(() -> assertSame("Junior Svømmer", main.findAgeGroup(17)),
                () -> assertSame("Senior Svømmer", main.findAgeGroup(18)),
                () -> assertSame("Pensionist Svømmer", main.findAgeGroup(61)),
                () -> assertSame("Senior Svømmer", main.findAgeGroup(60)));
    }

    @Test
    void findPrice() {
        Main main = new Main();
        assertAll(() -> assertEquals(1000,main.findPrice("Junior Svømmer")),
                () -> assertEquals(1600,main.findPrice("Senior Svømmer")),
                () -> assertEquals(1200,main.findPrice("Pensionist Svømmer")));
    }


}