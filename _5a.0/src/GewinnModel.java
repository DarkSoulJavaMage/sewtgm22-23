public class GewinnModel {
    //Attribute
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;
    //private GewinnView view;

    /**
     * alle Werte einstellen
     */
    public GewinnModel(){
        this.gesamtPunkte = 30;
        this.spielerZahl = 0;
        this.computerZahl = 0;
        this.rundenErgebnis = 0;
    }

    /**
     * gibt die Gesamtpunkte zurück
     * @return Gesamtpunkte
     */
    public int getGesamtPunkte(){
        return this.gesamtPunkte;
    }

    /**
     * gibt die computergenerierte Zahl zurück
     * @return computergenerierte Zahl
     */
    public int getComputerZahl(){
        return this.computerZahl;
    }

    /**
    /**
     * gibt das aktuelle Rundenergebnis zurück
     * @return ergebnis der runde
     */
    public int getRundenErgebnis(){
        return this.rundenErgebnis;
    }

    /**
     * berechnet eine random Zahl für die Computerzahl
     */
    public void berechneComputerZahl(){
        this.computerZahl = (int) (1 + (Math.random()*9));
    }

    /**
     * schaut wie viele Punkte der Spieler bekommt
     * @param spielerZahl zahl die der spieler eingegeben hat
     */
    public void berechneRunde(int spielerZahl){
        if(spielerZahl == computerZahl){
            gesamtPunkte += 20;
            rundenErgebnis = 20;
        }
        else if(spielerZahl+1 == computerZahl || spielerZahl-1 ==computerZahl){
            gesamtPunkte += 5;
            rundenErgebnis =5;
        }
        else{
            gesamtPunkte -= 10;
            rundenErgebnis=-10;
        }
    }

    /**
     * setzt alle Werte nach dem Ende der Runde wieder an den Anfang
     */
    public void anfang(){
        //view.farbePunkteGesamt(Color.WHITE);
        //view.farbePunkteAktuell(Color.WHITE);
        this.gesamtPunkte = 30;
        this.spielerZahl = 0;
        this.computerZahl = 0;
        this.rundenErgebnis = 0;
    }
}