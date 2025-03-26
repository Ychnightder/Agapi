package Models;

import java.util.List;

public class Association {
    private int id_association;
    private String nom_association;
    private String description;
    private String logo;
    private String site_web;
    private int idCategorie;


    private String imageUrls;



    public List<String> imagePresentation;

    public Association(int id_association, String nom_association, String description,String logo, String site_web, int idCategorie, String imageUrls) {
        this.id_association = id_association;
        this.nom_association = nom_association;
        this.description = description;
        this.logo = logo;
        this.site_web = site_web;
        this.idCategorie = idCategorie;
        this.imageUrls = imageUrls;
    }

    public int getId_association() {
        return id_association;
    }
    public String getNom_association() {
        return nom_association;
    }
    public String getDescription() {
        return description;
    }
    public String getLogo() {
        return logo;
    }
    public String getSite_web() {
        return site_web;
    }
    public int getIdCategorie() {
        return idCategorie;
    }
    public List<String> getImagePresentation() {
        return imagePresentation;
    }
    public void setImagePresentation(List<String> imagePresentation) {
        this.imagePresentation = imagePresentation;
    }
    public String getImageUrls() {
        return imageUrls;
    }

}