package Automatyczne;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Bercik
 */
public class Kasyno {

    Scanner scannerKasyno = new Scanner(System.in);
    Random randomKasyno = new Random();
    int wylosowanaLiczba = 0;
    int wylosowanyZnak = 0;
    int[][] talia = new int[5][14];
    int losowanieBlackJack = 0;
    int stanKasy = 1000;
    int stanKasyGracza = 100;
    String obecnaKarta = "";
    int sumaPunktow = 0;
    int sumaPunktowKrupier = 0;
    int stawkiBJ = 0;

    private static Kasyno inst;
    int decyzja = 0;
    int liczbaKart = 0;
    boolean graszDalej = true;

    public Kasyno() {
        int stanKasyGracza;
    }

    public static Kasyno inst() {
        if (inst == null) {
            inst = new Kasyno();
        }
        return inst;
    }

    boolean nastepnaKarta() {
        System.out.println("Podac nastepna karte?");
        System.out.println("1. Tak");
        System.out.println("2. Nie");
        boolean sprawdzeniePoprawnosciKarta = false;
        do {
            try {
                decyzja = scannerKasyno.nextInt();
                sprawdzeniePoprawnosciKarta = true;
            } catch (InputMismatchException g) {
                System.out.println("Niepoprawne dane. \nPowrot do menu.");
                break;
            }
        } while (sprawdzeniePoprawnosciKarta != true);
        if (decyzja == 1) {
            graszDalej = true;
        } else if (decyzja == 2) {
            graszDalej = false;
            System.out.println("Zakonczyles ruch. Ilosc twoich punktow: " + sumaPunktow);
        } else {
            System.out.println("Wyjscie z kasyna");
            graszDalej = false;
        }
        return graszDalej;
    }

    int sumaBlackJack(int suma) {
        sumaPunktow += suma;
        if (sumaPunktow > 21) {
            System.out.println("Gra skonczona. Przegrales.");
            graszDalej = false;
        }
        if (sumaPunktow == 21) {
            stanKasyGracza = stawkiBJ * 2;
            stanKasy -= stawkiBJ * 2;
            System.out.println("Trafiles oczko!");
            System.out.println("Wygrales: " + stawkiBJ * 2);
        }
        System.out.println("Suma twoich punktow to: " + sumaPunktow);
        return suma;
    }

    void graBlackJackKrupier() {
        System.out.println("---Kolejka Krupiera---");
        int sumaPunktowKrupiera = 0;
        int losowanieBlackJackKrupier = 0;
        do {
            losowanieBlackJackKrupier = konwersjaKart(losowanieKarty());
            System.out.println("Wylosowana karta: " + obecnaKarta + ". Karta ma wartosc: " + losowanieBlackJackKrupier);
            sumaPunktowKrupiera += losowanieBlackJackKrupier;
            System.out.println("Suma punktow krupiera: " + sumaPunktowKrupiera);
            if (sumaPunktowKrupiera > 21) {
                System.out.println("Krupier przegral");
                stanKasyGracza += stawkiBJ * 2;
                System.out.println("Wygrales: " + stawkiBJ * 2);
                return;
            }
            if (sumaPunktowKrupiera == 21) {
                System.out.println("Krupier trafil oczko");
                return;
            }
        } while (sumaPunktowKrupiera < sumaPunktow);
        System.out.println("Krupier wygral");
    }

    void menuGry() {
        int wyborOpcji = 0;
        boolean sprawdzaniePoprawnosciMenu = false;
        System.out.println("Witamy w kasynie!");
        System.out.println("Wpisywanie niepoprawnych danych bedzie skutkowalo powrotem do menu");
        for (;;) {
            do {
                try {
                    System.out.println("Wybierz gre: ");
                    System.out.println("1. Jednoreki Bandyta");
                    System.out.println("2. Black Jack");
                    System.out.println("3. Wyswietl stan banku");
                    System.out.println("4. Wyswietl stan twojego konta");
                    System.out.println("5. Wyjscie z gry");
                    wyborOpcji = scannerKasyno.nextInt();
                    sprawdzaniePoprawnosciMenu = true;
                } catch (InputMismatchException e) {
                    System.out.println("Niepoprawne dane. \n Wyjście z kasyna");
                    return;
                }
            } while (sprawdzaniePoprawnosciMenu != true);
            do {
                switch (wyborOpcji) {
                    case 1:
                        System.out.println("Wybrales Jednorekiego Bandyte!");
                        graJednorekiBandyta();
                        break;
                    case 2:
                        System.out.println("Wybrales Black Jack");
                        graBlackJack();
                        break;
                    case 3:
                        System.out.println("Stan banku to: " + stanKasy);
                        break;
                    case 4:
                        System.out.println("Stan twojego konta to: " + stanKasyGracza);
                        break;
                    case 5:
                        System.out.println("Dziekujemy za gre. Zapraszamy ponownie!");
                        return;
                    default:
                        System.out.println("Niepoprawna opcja. Wybierz numer jeszcze raz.");
                        break;
                }
            } while (sprawdzaniePoprawnosciMenu != true);
        }
    }

    void graJednorekiBandyta() {
        int stawkaJB = 0;
        int mnoznikStawkiJB = 5;
        int wylosowanaLiczba1 = 0;
        int wylosowanaLiczba2 = 0;
        int wylosowanaLiczba3 = 0;
        boolean sprawdzaniePoprawnosciJB = false;
        int graszDalejJB = 0;
        System.out.print("Podaj stawke: ");
        do {
            try {
                stawkaJB = scannerKasyno.nextInt();
                sprawdzaniePoprawnosciJB = true;
            } catch (InputMismatchException g) {
                System.out.println("Niepoprawne dane. \nPowrot do menu.");
                return;
            }
        } while (sprawdzaniePoprawnosciJB != true);
        if (stawkaJB > stanKasy || stawkaJB > stanKasyGracza) {
            System.out.println("Brak pieniedzy w kasie!");
            return;
        }
        System.out.println("Stawka zostala ustawiona. Nastepuje losowanie liczb");
        do {
            if (stawkaJB > stanKasy || stawkaJB > stanKasyGracza) {
                System.out.println("Brak pieniedzy w kasie!");
                return;
            }
            stanKasyGracza -= stawkaJB;
            wylosowanaLiczba1 = randomKasyno.nextInt(5);
            wylosowanaLiczba2 = randomKasyno.nextInt(5);
            wylosowanaLiczba3 = randomKasyno.nextInt(5);
            System.out.println("** " + wylosowanaLiczba1 + " *** " + wylosowanaLiczba2 + " *** " + wylosowanaLiczba3 + " **");
            if (wylosowanaLiczba1 == wylosowanaLiczba2 && wylosowanaLiczba2 == wylosowanaLiczba3) {
                System.out.println("Gratulacje wygrales! Wygrana kwota to: " + stawkaJB * mnoznikStawkiJB);
                stanKasy -= stawkaJB * mnoznikStawkiJB;
                stanKasyGracza += stawkaJB * mnoznikStawkiJB;
            } else {
                System.out.println("Przegrales!");
                stanKasy += stawkaJB;
            }
            System.out.println("Grasz dalej?");
            System.out.println("1. Tak");
            System.out.println("2. Nie");
            do {
                try {
                    graszDalejJB = scannerKasyno.nextInt();
                    sprawdzaniePoprawnosciJB = true;
                } catch (InputMismatchException e) {
                    System.out.println("Niepoprawne dane. \nPowrot do menu.");
                    return;
                }
                if (stanKasyGracza <= 0) {
                    System.out.println("Nie masz piniedzy na gre!");
                    return;
                }
            } while (sprawdzaniePoprawnosciJB != true);
            switch (graszDalejJB) {
                case 1:
                    sprawdzaniePoprawnosciJB = true;
                    if (stanKasy < stawkaJB) {
                        System.out.println("Brakuje pieniedzy!");
                        return;
                    }
                    break;
                default:
                    System.out.println("Powrot do menu");
                    return;
            }
        } while (sprawdzaniePoprawnosciJB = true);
    }

    void graBlackJack() {
        int stawkaBJ = 0;
        boolean sprawdzaniePoprawnosciBJ = false;
        System.out.print("Podaj stawke: ");
        do {
            try {
                stawkaBJ = scannerKasyno.nextInt();
                sprawdzaniePoprawnosciBJ = true;
            } catch (InputMismatchException e) {
                System.out.println("Niepoprawne dane. \nPowrot do menu.");
                return;
            }
        } while (sprawdzaniePoprawnosciBJ != true);
        if (stawkaBJ > stanKasyGracza) {
            System.out.println("Brak pieniedzy!");
            return;
        }
        System.out.println("Stawka zostala ustawiona. Nastepuje rozdawanie kart.");
        System.out.println("Twoja kolejka.");
        stawkiBJ = stawkaBJ;
        stanKasyGracza -= stawkaBJ;
        nowaTalia();
        sumaPunktow = 0;
        do {
            losowanieBlackJack = konwersjaKart(losowanieKarty());
            System.out.println("Wylosowana karta: " + obecnaKarta + ". Karta ma wartosc: " + losowanieBlackJack);
            sumaBlackJack(losowanieBlackJack);
            if (graszDalej == true) {
                nastepnaKarta();
            }
        } while (graszDalej == true);
        if (sumaPunktow > 21 || sumaPunktow == 21) {
            return;
        }
        graBlackJackKrupier();
    }

    void nowaTalia() {
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 13; j++) {
                talia[i][j] = 1;
            }
        }
    }

    int losowanieLiczby() {
        return wylosowanaLiczba = randomKasyno.nextInt(13) + 1;
    }

    int losowanieZnaku() {
        return wylosowanyZnak = randomKasyno.nextInt(4) + 1;
    }

    int losowanieKarty() {
        int b = losowanieLiczby();
        int a = losowanieZnaku();
        if (talia[a][b] == 0) {
            losowanieKarty();
        }
        talia[a][b] = 0;
        return b;
    }

    int konwersjaKart(int c) {
        if (c == 1) {
            obecnaKarta = "As";
        } else if (c > 10) {
            if (c == 11) {
                obecnaKarta = "Walet";
                c = 10;
            }
            if (c == 12) {
                obecnaKarta = "Krolowa";
                c = 10;
            }
            if (c == 13) {
                obecnaKarta = "Krol";
                c = 10;
            }
        } else {
            obecnaKarta = Integer.toString(c);
        }
        return c;
    }

    public static void main(String[] args) {
        Kasyno gracz = new Kasyno();
        gracz.menuGry();
    }
}

class Singleton {

    private static Integer inst;

    public Singleton(){
        
    }
    public Singleton(int stanKasy){
        inst = stanKasy;
    }

    public static synchronized Integer getInstance() {
        if (inst == null) {
            inst = new Integer(0);
        }
        return inst;
    }

}
