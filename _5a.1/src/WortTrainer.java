import java.math.*;
/**
 * In dieser Klasse wird das Konstrukt unseres Spieles abgerufen
 * @author Andreas Proschek
 * @version 22-10-2023
 */


public class WortTrainer {
    private WortListe liste;
    private WortEintrag eintrag;





    //Setter
    public void setListe(WortListe liste) {
        if(liste == null){
            throw new IllegalArgumentException("Die Liste ist leer!");
        }
        this.liste = liste;
    }


    public WortListe getListe() {
        return liste;
    }


    //Getter
    public WortEintrag getEintrag() {
        return eintrag;
    }


    //Setter
    public void setEintrag(WortEintrag eintrag) {
        this.eintrag = eintrag;
    }



    public WortTrainer(WortListe liste){
        setListe(liste);
        setEintrag(this.liste.getWort(0));
    }




    public WortTrainer(){
        this.liste = new WortListe();
        this.eintrag = this.liste.getWort(0);
    }




    public void zufallWort(){
        int random = (int)Math.random() * this.liste.listelaenge();
        eintrag = this.liste.getWort(random);
    }

    public boolean check(String wort){
        return checkIgnoreCase(wort, false);
    }


    public boolean checkIgnoreCase(String wort, boolean ignoreCase){
        if(wort == null || wort.length() < 2){
            throw new IllegalArgumentException("Wort ungültig 2<!");
        }
        if(ignoreCase == true){
            return wort.toLowerCase().trim().equals(this.eintrag.getWort().toLowerCase().trim());
        }
        else{
            return wort.equals(this.eintrag.getWort());
        }
    }
}