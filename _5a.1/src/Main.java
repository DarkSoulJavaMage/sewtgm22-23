/**
 * In dieser Klasse werden alle Methoden und Klassen überprüft
 * @author Andreas Proschek
 * @version 22-10-2023
 */

public class Main {
    public static void main(String[] args) {
        //
        System.out.println("Testung Konstruktor");
        WortEintrag eintrag = new WortEintrag("Julian", "http://orf.at");
        System.out.println(eintrag.toString());


        System.out.println("Testung Konstruktor");
        WortEintrag eintrag2 = new WortEintrag();
        System.out.println(eintrag2.toString());

        System.out.println("Testung checkURL");
        System.out.println("Test1: " + eintrag.checkURL());
        System.out.println("Test2: " + eintrag2.checkURL());

        //Fehlerfall testen
        WortEintrag fehlerEintrag = new WortEintrag("banana", "sdf://domain");
        System.out.println("Test3: " + fehlerEintrag.checkURL());

        //WortListe
        System.out.println("Testung Konstruktor");
        WortEintrag[] array1 = {eintrag, eintrag2};
        WortListe liste1 = new WortListe(array1);
        System.out.println(liste1.toString());

        System.out.println("Testung Konstruktor");
        WortListe liste2 = new WortListe();
        System.out.println(liste2.toString());

        System.out.println("Testung Eintrage");
        liste1.wortHinzu(new WortEintrag("lala", "https://csgo.com"));
        System.out.println(liste1.toString());

        System.out.println("Testeb der Methode zum Entfernen von Einträgen: ");
        liste1.removeWort("lala");
        System.out.println(liste1.toString());

        //WortTrainer
        System.out.println("\nTestung der Klasse WortTrainer:");
        System.out.println("Testung der WortTrainer:");
        WortTrainer trainer1 = new WortTrainer(liste1);
        System.out.println(trainer1.getEintrag().toString());

        System.out.println("Testung der zufälligen Wortauswahl:");
        trainer1.zufallWort();
        System.out.println(trainer1.getEintrag().toString());



        System.out.println("Testung der check Methode:");
            trainer1.setEintrag(eintrag);
                System.out.println("Testung der check Methode mit Groß- Kleinschreibung:");
                    System.out.println(trainer1.check("Andreas"));
                        System.out.println(trainer1.check("ANDREAS"));

        System.out.println("Testung der check Methode ohne Groß- Kleinschreibung:");
        System.out.println(trainer1.checkIgnoreCase("Andreas", true));
        System.out.println(trainer1.checkIgnoreCase("ANDREAS", true));
    }
}