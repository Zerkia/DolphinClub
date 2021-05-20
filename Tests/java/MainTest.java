import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void findAgeGroup() {
        MedlemsListe medlemsListe = new MedlemsListe();
        assertAll(() -> assertSame("Junior Svømmer", medlemsListe.findAgeGroup(17)),
                () -> assertSame("Senior Svømmer", medlemsListe.findAgeGroup(18)),
                () -> assertSame("Pensionist Svømmer", medlemsListe.findAgeGroup(61)),
                () -> assertSame("Senior Svømmer", medlemsListe.findAgeGroup(60)));
    }

    @Test
    void findPrice() {
        MedlemsListe medlemsListe = new MedlemsListe();
        assertAll(() -> assertEquals(1000, medlemsListe.findPrice("Junior Svømmer")),
                () -> assertEquals(1600,medlemsListe.findPrice("Senior Svømmer")),
                () -> assertEquals(1200,medlemsListe.findPrice("Pensionist Svømmer")));
    }


}