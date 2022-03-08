import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

class Banque extends UnicastRemoteObject implements IBanque {
    ArrayList<Compte> comptes;

    Banque() throws RemoteException {
        comptes = new ArrayList<>();
    }

    @Override()
    public String etatDeCompte(Compte compte) {
        return "Personne " + compte.getPersonne() + " montant " + compte.getMontant();
    }

    public void ajouterCompte(Compte compte) {
        comptes.add(compte);

    }

    public Compte creerCompte(Personne personne, int montant) {
        Compte compte = new Compte(personne, montant);
        return compte;
    }

    public String enleverCompte(Compte compte) throws RemoteException {

        if (!this.comptes.contains(compte))
            throw new RemoteException("404 Account not found");
        this.comptes.remove(compte);
        return "Account successfully deleted";
    }

    public String transfertEntreCompte(Compte src, Compte dest, int montant) {
        if (!comptes.contains(src))
            return "404 Compte origine n'existe pas";
        if (!comptes.contains(dest))
            return "404 Compte destinataire n'existe pas";

        try {
            src.setMontant(src.getMontant() - montant);
            dest.setMontant(dest.getMontant() - montant);

            return "Operation successfull !";
        } catch (Exception error) {
            return "401 Unauthorized Operation";
        }
    }

    public String getValeurCompte(Compte compte) {

        for (Compte itCompte : comptes) {
            if (itCompte.equals(compte)) {
                return "Valeur du compte " + itCompte.montant;
            }

        }
        return "404 Compte pas trouve";
    }

    public Compte setValeurCompte(Compte compte, int montant) {

        for (Compte itCompte : comptes) {
            if (itCompte.equals(compte)) {
                itCompte.setMontant(montant);
                compte = itCompte;
            }
        }
        return compte;
    }

}
