import java.awt.*;
import java.awt.event.*;

public class GewinnControll implements ActionListener, KeyListener {

    private GewinnFrame frame;
    private GewinnView view;
    private GewinnModel model;

    /**
     * setzt die werte
     */
    public GewinnControll(){
        view = new GewinnView(this);
        frame = new GewinnFrame(view);
        model = new GewinnModel();
    }

    /**
     * startet eine neue runde
     * @param e the event to be processed
     */
    public void actionPerformed (ActionEvent e) {
        model.anfang();
        view.farbePunkteGesamt(Color.WHITE);
        view.farbePunkteAktuell(Color.WHITE);
        view.sperrenButton(true);
        view.sperrenText(false);
        view.setPunkteGesamt(30);
        view.setPunkteAktuell(0);
    }

    /**
     * wenn man enter drückt
     * @param e the event to be processed
     */
    public void keyPressed (KeyEvent e){
        if(e.getKeyChar() == KeyEvent.VK_ENTER){                    //schaut ob enter gedrückt wurde
            try{
                model.berechneComputerZahl();                       //holt die Computerzahl
                int spielerZahl = view.getSpieler();                //holt die Spielerzahl
                if(spielerZahl <= 0 || spielerZahl >= 10){          //schaut, ob das richtige eingegeben wurde
                    throw new NumberFormatException();              //wenn nicht, kommt eine exception
                }
                model.berechneRunde(spielerZahl);                   //berechnet wie viele Punkte der Spieler bekommt
                view.setComputer(model.getComputerZahl());          //zeigt die Spielerzahl
                view.setPunkteAktuell(model.getRundenErgebnis());   //zeigt die aktuellen Punkte
                view.setPunkteGesamt(model.getGesamtPunkte());      //zeigt die Punkte gesamt
                if(model.getGesamtPunkte() >= 100) {                //schaut, ob gewonnen
                    gewonnen();
                }
                if(model.getGesamtPunkte() <= 0) {                  //schaut, ob verloren
                    verloren();
                }
                view.sperrenButton(false);                      //sperrt den button
                view.leer();                                        //macht das Textfeld leer
            }
            catch(NumberFormatException exc){
                System.out.println("Es wurde ein falscher Wert eingegeben!");
            }
        }
    }

    public void keyReleased (KeyEvent e) {

    }

    public void keyTyped (KeyEvent e) {

    }

    /**
     * wenn gewonnen ändert es die farbe, sperrt das textfeld und gibt den button frei
     */
    public void gewonnen () {
        view.farbePunkteGesamt(Color.green);
        view.farbePunkteAktuell(Color.GREEN);
        view.setPunkteGesamtString("GEWONNEN!");
        view.sperrenText(true);
        view.sperrenButton(false);
    }

    /**
     * wenn verloren ändert es die farbe, sperrt den text und gibt den button frei
     */
    public void verloren () {
        view.farbePunkteGesamt(Color.RED);
        view.farbePunkteAktuell(Color.RED);
        view.setPunkteGesamtString("VERLOREN!");
        view.sperrenText(true);
        view.sperrenButton( false);
    }

    /**
     * Main-Methode
     * @param args main
     */
    public static void main(String[] args) {
        new GewinnControll();
    }
}
