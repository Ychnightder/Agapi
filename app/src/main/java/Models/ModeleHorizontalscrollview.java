package Models;

public class ModeleHorizontalscrollview {
    private String nomAssociation;
    private String imageAssociationUrl;

    public ModeleHorizontalscrollview(String imageAssociationUrl, String nomAssociation) {
        this.imageAssociationUrl = imageAssociationUrl;
        this.nomAssociation = nomAssociation;
    }

    public String getNomAssociation() {
        return nomAssociation;
    }

    public String getImageAssociationUrl() {
        return imageAssociationUrl;
    }
}
