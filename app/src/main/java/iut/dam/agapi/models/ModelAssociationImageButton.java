package iut.dam.agapi.models;

public class ModelAssociationImageButton {

    int imageButton;
    String nomAsso;


    public ModelAssociationImageButton(int imageButton, String nomAsso) {
        this.imageButton = imageButton;
        this.nomAsso = nomAsso;
    }

    public int getImageButton() {
        return imageButton;
    }

    public String getNomAsso() {
        return nomAsso;
    }
}
