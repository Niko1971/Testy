
import automatyczne.Automatyczne;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bercik
 */
public class AutomatyczneTest {

    public AutomatyczneTest() {
    }

    @Test
    public void rownanie1() {
        Automatyczne testy = new Automatyczne();
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        list2.add(-3.0);
        list1 = testy.rownanie(1, 6, 9);
        assertTrue("Listy nie sa takie same", list1.containsAll(list2));
    }

    @Test
    public void rownanie2() {
        Automatyczne testy = new Automatyczne();
        ArrayList lista1 = new ArrayList();
        ArrayList lista2 = new ArrayList();
        lista1 = testy.rownanie(1, 6, 9);
        lista2.add(-3.0);
        assertEquals("Wyniki sa rozne", lista1, lista2);
    }

    @Test
    public void rownanie3() {
        Automatyczne testy = new Automatyczne();
        ArrayList lista1 = new ArrayList();
        lista1 = testy.rownanie(1, 6, 9);
        assertNotNull("Liczby nie sa takie same ", lista1);
    }

    @Test
    public void losowanie1() {
        Automatyczne testy = new Automatyczne();
        assertTrue("Czas został przekroczony", testy.losowanie(10000000) < 100000);
    }

    @Test
    public void losowanie2() {
        Automatyczne testy = new Automatyczne();
        assertTrue("Czas został przekroczony", testy.losowanie(10000000) < 50000);

    }

    @Test
    public void losowanie3() {
        Automatyczne testy = new Automatyczne();
        assertTrue("Czas został przekroczony", testy.losowanie(10000000) < 4000);

    }

    @Test
    public void kasyna1() {
        Automatyczne testy = new Automatyczne();
        int a = testy.kasyno2();
        int b = 4;
        assertFalse("Zostala wylosowana nieprawidlowa liczba", a > b);
    }

    @Test
    public void kasyna2() {
        Automatyczne testy = new Automatyczne();
        int a = testy.kasyno2();
        int b = 14;
        assertFalse("Zostala wylosowana nieprawidlowa liczba", a > b);
    }

    @Test
    public void kasyna3() {
        Automatyczne testy = new Automatyczne();
        ArrayList lista1 = new ArrayList();
        ArrayList lista2 = new ArrayList();
        lista1 = testy.kasyno3();
        lista2.add("As");
        assertEquals("Nieprawidlowa konwersja liczb", lista1, lista2);
    }

    @Test
    public void kasyna4() {
        Automatyczne testy = new Automatyczne();
        ArrayList lista1 = new ArrayList();
        ArrayList lista2 = new ArrayList();
        lista1 = testy.kasyno4();
        lista2.add("Przepełnienie");
        assertEquals("Przepełnienie nie działa prawidlowo", lista1, lista2);
    }

    @Test
    public void kasyna5() {
        Automatyczne testy = new Automatyczne();
        int a = testy.kasyno5();
        int b = 6;
        assertFalse("Zostala wylosowana nieprawidlowa liczba", a > b);
    }

    @Test
    public void kasyna6() {
        Automatyczne testy = new Automatyczne();
        int a = testy.kasyno5();
        assertNotNull("Brak liczby", a);
    }

    @Test
    public void kasyna7() {
        Automatyczne testy = new Automatyczne();
        int a = testy.kasyno2();
        assertNotNull("Brak liczby", a);
    }

    @Test
    public void kasyna8() {
        Automatyczne testy = new Automatyczne();
        int a = testy.kasyno1();
        assertTrue("Nieprawidlowa liczba", a < 14);
    }

    @Test
    public void kasyna9() {
        Automatyczne testy = new Automatyczne();
        int a = testy.kasyno2();
        assertTrue("Nieprawidlowa liczba", a < 5);
    }
}
