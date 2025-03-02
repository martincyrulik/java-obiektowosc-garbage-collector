/**
 * Zmienne są przechowywane na stosie, a obiekty na stercie.
 * Zmienna przechowuje referencję (wskaźnik) do obiektu.
 * Zmienna żyje w zakresie bloku, gdzie była zadeklarowana.
 * Po wyjściu z niego zostaje usunięta z pamięci.
 * Natomiast obiekt zostaje usunięty przez Garbage Collector, gdy zniknie
 * jakakolwiek referencja do tego obiektu.
 */

public class Main {
    public static void main(String[] args) {

        //tworzę obiekty klasy Car
        Car privateCar = new Car(1990, 24012);
        Car companyCar = new Car(2010, 31052);
        Car wifeCar = new Car(2001, 15022);

        //mamy teraz 3 zmienne przechowywane na stosie, które przechowują
        //referencje do 3 obiektów przechowywanych na stercie - wskazują na te obiekty
        /**
         * privateCar -------------------------------> productionYear: 1990
         *                                             price: 24012
         *
         * companyCar -------------------------------> productionYear: 2010
         *                                             price: 31052
         *
         * wifeCar ----------------------------------> productionYear: 2001
         *                                             price: 15022
         *
         *  Stos                                        Sterta
         */

        //załóżmy że mieliśmy wypadek, i nie możemy już używać smaochodu służbowego,
        //teraz używamy samochodu prywatnego do celów złużbowych, zapiszę to w Javie:

        companyCar = privateCar;

        //Zmiena companyCar zaczyna teraz wskazywać na zupełnie inny obiekt, na
        //ten sam co zmienna privateCar. Konsekwencje tego faktu są takie:
        //1) Garbage Collector zauważy obiekt, na którego nic nie wskazuje, więc go usunie.
        //      --> w pamięci będziemy mieć 3 zmienne i 2 obiekty.
        //2) Skoto 2 zmienne wskazują na ten sam obiekt , to te obie zmienne moga
        //modyfikować ten sam obiekt. Np.

        privateCar.price = 19299; //ta zmiana wpłynie na cenę auta służbowego, bo są to te same auta
        System.out.println("Company's car price is equal: " + companyCar.price);

        //Działa to również w drugą stronę, czyli zmieńmy np. rok produkcji auta służbowego
        //i zobaczymy, że rok produkcji auta prywatnego też się zmieni

        companyCar.productionYear = 2020;
        System.out.println("Private car production year is equal: " + privateCar.productionYear);

        /**
         * W tej sytuacji jawnie powiedzieliśmy: nie chcę już wskazywać na ten obiekt, chcę na inny
         * Przez co utracił on referencję i Garbage Collector go usunął.
         * Obiekt może też utracić referencję, gdy zmienna zostanie usunięta z powodu wyjścia z jej
         * zakresu. W takiej sytuacji najpierw zostanie usunięta zmienna, a potem
         * obiekt na który wskazywała zmienna.
         */

    }
}
