
public class WortEintrag {
    private String wort;
    private String url;


    public WortEintrag(String wort, String url){
        this.wort = wort;
        this.url = url;
    }
    public WortEintrag(){
        this.wort = "Example";
        this.url = "https://Example.com";
    }



    public String getWort() {
        return wort;
    }
    public String getUrl() {
        return url;
    }
    public void setWort(String wort) {
        if(wort != null && wort.length() >= 2) {
            this.wort = wort;
        }
        else{
            throw new IllegalArgumentException("Wort zu war zu kurz!");
        }
    }
    public void setUrl(String url) {
        this.url = url;
    }


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


    @Override
    public String toString(){
        return wort + "; " + url;
    }
}