
public class WortListe {
    private WortEintrag[] liste;




    public WortListe(WortEintrag[] liste){
        if(liste != null){
            this.liste = liste;
        }
        else{
            throw new IllegalArgumentException("Nichts wurde eingetragen!");
        }
    }




    public WortListe(){
        this.liste = new WortEintrag[0];
        wortHinzu(new WortEintrag());
    }

    public int listelaenge(){
        return this.liste.length;
    }





    public void wortHinzu(WortEintrag neueWort){
        if(this.liste == null){
            throw new IllegalArgumentException("No Wortliste!");
        }
        Boolean hinzu = false;
        for(int i = 0; i < this.liste.length; i++){
            if(this.liste[i] == null){
                this.liste[i] = neueWort;
                hinzu = true;
                break;
            }
        }
        //falls die liste zu kurz ist, wird sie verlängert
        if(hinzu == false){
            WortEintrag[] listeTemp = new WortEintrag[this.liste.length + 1];
            for(int i = 0; i < this.liste.length; i++){
                listeTemp[i] = this.liste[i];
            }
            listeTemp[this.liste.length] = neueWort;
            this.liste = listeTemp;
        }
    }




    public WortEintrag getWort(int index){
        if(index > this.liste.length || liste[index] == null){
            throw new IllegalArgumentException("Index ungültig!");
        }
        return this.liste[index];
    }




    public boolean removeWort(String wort){
        if(wort.length() < 2 || wort == null){
            throw new IllegalArgumentException("Wort muss länger als 2 Buchstaben sein!");
        }
        for(int i = 0; i < this.liste.length; i++){
            if(this.liste[i].getWort().equals(wort)){
                this.liste[i] = null;
                return true;
            }
        }
        return false;
    }






    @Override
    public String toString(){
        String text = "";
        for(int i = 0; i < this.liste.length; i++){
            if(this.liste[i] != null){
                text += this.liste[i].toString() + "\n";
            }
        }
        return text;
    }
}