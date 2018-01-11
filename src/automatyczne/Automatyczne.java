package automatyczne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Automatyczne {

    public static ArrayList rownanie(int a, int b, int c) {
        ArrayList lista = new ArrayList();
        if (a != 0) {
            int delta = b * b - 4 * a * c;
            delta = (int) Math.sqrt(delta);
            if (delta > 0) {
                lista.add((double) ((-b - delta) / (2 * a)));
                lista.add((double) ((-b + delta) / (2 * a)));
            } else if (delta == 0) {
                lista.add((double) (-b / (2 * a)));
            }
        }
        return lista;
    }

    public static long losowanie(int number) {
        long poczatek = System.currentTimeMillis();
        ArrayList lista = new ArrayList();
        Random rand = new Random();
        for (int i = 0; i < number; i++) {
            lista.add(rand.nextInt(9) + 1);
        }
        Collections.sort(lista);
        long koniec = System.currentTimeMillis();
        return (koniec - poczatek);
    }

    public static int kasyno1() {
        Random rand = new Random();
        int a = rand.nextInt(13) + 1;
        return a;
    }

    public static int kasyno2() {
        Random rand = new Random();
        int a = rand.nextInt(4) + 1;
        return a;
    }

    public static ArrayList kasyno3() {
        ArrayList lista = new ArrayList();
        int a = 1;
        if (a == 1) {
            lista.add("As");
        }
        return lista;
    }

    public static ArrayList kasyno4() {
        ArrayList lista = new ArrayList();
        Random rand = new Random();
        int suma = 0;
        while (suma < 22) {
            int a = rand.nextInt(13) + 1;
            suma += a;
        }
        if (suma >= 22) {
            lista.add("Przepełnienie");
        }
        return lista;
    }

    public static int kasyno5() {
        Random rand = new Random();
        int a = rand.nextInt(5) + 1;
        return a;
    }

    public static void main(String[] args) {

    }

}
