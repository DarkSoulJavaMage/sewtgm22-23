public class WortEintrag {


    private String wort; // Attribute for storing the word
    private String url;  // Attribute for storing the URL




    // Constructor
    public WortEintrag(String tiernamein, String urlin) {

    }




    //Checks url
    public static boolean checkURL(String eingabeURL) {
        if (eingabeURL != null) {





        }else{
            throw new IllegalArgumentException("Wort zu kurz!");
        }

        return false;
    }





    // Getter for 'wort'
    public String getWort() {
        return this.wort;
    }

    // Getter for 'url'
    public String getUrl() {
        return this.url;
    }




    // Setter for 'url'
    public void setWort(String wortEinleseHilfe) {
        this.wort = wortEinleseHilfe;
    }
    // Setter for 'url'
    public void setUrl(String urlEinleseHilfe) {
        this.url = urlEinleseHilfe;
    }


    @Override
    public String toString(){
        return wort + "; " + url;
    }


}