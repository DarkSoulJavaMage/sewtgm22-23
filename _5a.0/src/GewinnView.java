import javax.swing.*;
import java.awt.*;

public class GewinnView extends JPanel{
        //Attribute
        private JLabel gesamt, aktuell, punkteGesamt, punkteAktuell, computerzahl, naechsteRunde;
        private JTextField spieler, computer;
        private JButton nochmal;
        private JPanel grid;

        /**
         * erstellt das frame und fügt die ganzen sachen hinzu
         * @param hilfeListener actionlistener
         */
        public GewinnView(GewinnControll hilfeListener) {
                BorderLayout manager = new BorderLayout();
                this.setLayout(manager);
                grid = new JPanel(new GridLayout(4, 2));
                this.add(grid, BorderLayout.NORTH);

                gesamt = new JLabel("Punkte gesamt:");
                grid.add(gesamt);
                aktuell = new JLabel("Aktuelles Ergebnis:");
                grid.add(aktuell);
                punkteGesamt = new JLabel();
                punkteGesamt.setOpaque(true);           //damit man die farbe ändern kann
                grid.add(punkteGesamt);
                punkteAktuell = new JLabel();
                punkteAktuell.setOpaque(true);
                grid.add(punkteAktuell);
                naechsteRunde = new JLabel("Zahl für die nächste Runde:");
                grid.add(naechsteRunde);
                computerzahl = new JLabel("Computerzahl:");
                grid.add(computerzahl);
                spieler = new JTextField();
                spieler.addKeyListener(hilfeListener);
                grid.add(spieler);
                computer = new JTextField();
                computer.setEditable(false);
                computer.setPreferredSize(new Dimension(30, 50));
                grid.add(computer);

                nochmal = new JButton("Noch einmal!");
                nochmal.addActionListener(hilfeListener);
                this.add(nochmal, BorderLayout.SOUTH);
        }

        /**
         * gibt die Zahl die der spieler eingegeben hat zurück
         * @return zahl vom spieler
         */
        public int getSpieler() {
                return Integer.parseInt(spieler.getText());
        }

        /**
         * setzt die insgesamten punkte vom spieler
         * @param g punkte
         */
        public void setPunkteGesamt(int g){
                punkteGesamt.setText(Integer.toString(g));
        }

        /**
         * setzt die aktuellen punkte der runde
         * @param a punkte
         */
        public void setPunkteAktuell(int a){
                punkteAktuell.setText(Integer.toString(a));
        }

        /**
         * setzt die zahl vom computer
         * @param c zahl
         */
        public void setComputer(int c){
                computer.setText(Integer.toString(c));
        }

        /**
         * setzt die farbe vom label 'punktegesamt'
         * @param fg farbe
         */
        public void farbePunkteGesamt(Color fg){
                punkteGesamt.setBackground(fg);
        }

        /**
         * setzt die farbe vom label 'punkteaktuell'
         * @param fa farbe
         */
        public void farbePunkteAktuell(Color fa){
                punkteAktuell.setBackground(fa);
        }

        /**
         * setzt die punkte asls string
         * @param g punkte string
         */
        public void setPunkteGesamtString(String g){
                punkteGesamt.setText(g);
        }

        /**
         * sperrt den text
         * @param st ja oder nein
         */
        public void sperrenText(boolean st){
                spieler.setEditable(!st);
        }

        /**
         * sperrt den button
         * @param sb ja oder nein
         */
        public void sperrenButton(boolean sb){
                nochmal.setEnabled(!sb);
        }

        /**
         * macht das Textfeld wieder leer
         */
        public void leer(){
                spieler.setText("");
        }
}
