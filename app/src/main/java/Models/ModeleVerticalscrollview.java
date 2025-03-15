package Models;

public class ModeleVerticalscrollview {
    String nomAssociation;
    int iconeAssociation;

    String descriptionAsso;

    int imageAssociation;


    public ModeleVerticalscrollview(String nomAssociation, int iconeAssociation, String descriptionAsso, int imageAssociation) {
        this.nomAssociation = nomAssociation;
        this.iconeAssociation = iconeAssociation;
        this.descriptionAsso = descriptionAsso;
        this.imageAssociation = imageAssociation;
    }

    public String getNomAssociation() {
        return nomAssociation;
    }

    public int getIconeAssociation() {
        return iconeAssociation;
    }

    public String getDescriptionAsso() {
        return descriptionAsso;
    }

    public int getImageAssociation() {
        return imageAssociation;
    }
}
