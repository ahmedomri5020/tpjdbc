package ma.projet.beans;

public class client {
    private int id;
    private String nom;
    private String prenom;

    // Constructeur avec 3 paramètres
    public client(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    // Constructeur avec 2 paramètres (nom et prenom)
    public client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    // Getter pour id
    public int getId() {
        return id;
    }

    // Setter pour id
    public void setId(int id) {
        this.id = id;
    }

    // Getter pour nom
    public String getNom() {
        return nom;
    }

    // Setter pour nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour prenom
    public String getPrenom() {
        return prenom;
    }

    // Setter pour prenom
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
