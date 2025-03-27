package Models;

public class ModeleVerticalscrollview {
    private String nom;
    private String logoUrl;
    private String description;
    private String imageUrl;

    public ModeleVerticalscrollview(String nom, String logoUrl, String description, String imageUrl) {
        this.nom = nom;
        this.logoUrl = logoUrl;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getNomAssociation() {
        return nom;
    }

    public String getIconeAssociationUrl() {
        return logoUrl;
    }

    public String getDescriptionAsso() {
        return description;
    }

    public String getImageAssociationUrl() {
        return imageUrl;
    }
}
