public class WortEintrag {


    private String wort; // Attribute for storing the word
    private String url;  // Attribute for storing the URL




    // Constructor
    public WortEintrag(String tiernamein, String urlin) {
        this.wort = tiernamein;
        this.url = urlin;
    }




    //Checks url
    public boolean checkURL(){
        String http;
        String domain;
        String file = "";
        int index;

        if(this.url.substring(0,8).equals("https://")){
            http = this.url.substring(0,8);
        }
        else{
            if(this.url.substring(0,7).equals("http://")){
                http = this.url.substring(0,7);
            }
            else{
                return false;
            }
        }

        //domain vom Rest abspalten
        domain = this.url.substring(http.length(), this.url.length());

        index = domain.indexOf('.');
        file = domain.substring(index, domain.length());
        domain = domain.substring(0, index);

        //checkt, ob auf dem http/https ein Buchstabe folgt
        if(domain.substring(0,1).matches("[A-Za-z]") == false){
            return false;
        }

        //checkt, ob auf den punkt ein Buchstabe folgt
        if(file.substring(1,2).matches("[A-Za-z]") == false){
            return false;
        }
        return true;
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
    public void setWort(String wort) {
        if(wort != null && wort.length() >= 2) {
            this.wort = wort;
        }
        else{
            throw new IllegalArgumentException("Wort zu kurz!");
        }
    }



    // Setter for 'url'
    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString(){
        return wort + "; " + url;
    }


}