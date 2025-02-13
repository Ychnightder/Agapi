package iut.dam.agapi.databases.models;
public class Association {
    private int id;
    private String nom;
    private String description;
    private String logo;
    private String qrCode;

    public Association(int id, String nom, String description, String logo, String qrCode) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.logo = logo;
        this.qrCode = qrCode;
    }
    public Association(String nom, String description, String logo, String qrCode) {
        this.nom = nom;
        this.description = description;
        this.logo = logo;
        this.qrCode = qrCode;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public String getLogo() { return logo; }
    public String getQrCode() { return qrCode; }

    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setDescription(String description) { this.description = description; }
    public void setLogo(String logo) { this.logo = logo; }
    public void setQrCode(String qrCode) { this.qrCode = qrCode; }
}