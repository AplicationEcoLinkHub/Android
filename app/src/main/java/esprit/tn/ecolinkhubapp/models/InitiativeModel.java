package esprit.tn.ecolinkhubapp.models;

public class InitiativeModel {
    private String titre;
    private String description;
    private String heure;

    private String numero;
    private String localisation;


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }





    public InitiativeModel(String titre, String description, String heure, String numero, String localisation, String photo) {
        this.titre = titre;
        this.description = description;
        this.heure = heure;
        this.numero = numero;
        this.localisation = localisation;

    }

}
