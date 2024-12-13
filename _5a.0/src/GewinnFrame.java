import javax.swing.*;

public class GewinnFrame extends JFrame {
    /**
     * erstellt das frame
     * @param helpView hilft
     */
    public GewinnFrame(GewinnView helpView) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.add(helpView);
        this.setTitle("Gewinnspiel");
        this.setVisible(true);
    }
}
