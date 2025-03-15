package Models;

public class ModeleHorizontalscrollview {
    String nomAssociation;
    int imageAssociation;


    public ModeleHorizontalscrollview(int imageAssociation, String nomAssociation) {
        this.imageAssociation = imageAssociation;
        this.nomAssociation = nomAssociation;
    }

    public String getNomAssociation() {
        return nomAssociation;
    }

    public int getImageAssociation() {
        return imageAssociation;
    }
}
