public class Compte implements java.io.Serializable {
    Personne personne;
    int montant;

    Compte(Personne personne) {
        this.personne = personne;
    }

    Compte(Personne personne, int montant) {
        this.setMontant(montant);
        this.personne = personne;
    }

    public void setMontant(int nouvMontant) {
        this.montant = nouvMontant;
    }

    public int getMontant() {
        return this.montant;
    }

    public Personne getPersonne() {
        return this.personne;
    }

}