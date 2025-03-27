package Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Association {
    private int id_association;
    private String nom_association;
    private String description;
    private String logo;
    private String site_web;
    private int idCategorie;

    @SerializedName("imagePresentation")
    private String imagePresentationRaw; // recupere tous les URL

    private transient List<String> imagePresentation;

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

    public String getImagePresentationRaw() {
        return imagePresentationRaw;
    }

    public List<String> getImagePresentation() {
        return imagePresentation;
    }

    public void setImagePresentation(List<String> imagePresentation) {
        this.imagePresentation = imagePresentation;
    }
}
