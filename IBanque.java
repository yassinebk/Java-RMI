import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBanque extends Remote {

    String etatDeCompte(Compte compte) throws RemoteException;

    void ajouterCompte(Compte compte) throws RemoteException;

    Compte creerCompte(Personne personne, int montant) throws RemoteException;

    String enleverCompte(Compte compte) throws RemoteException;

    String transfertEntreCompte(Compte src, Compte dest, int montant) throws RemoteException;

    String getValeurCompte(Compte compte) throws RemoteException;

    Compte setValeurCompte(Compte compte, int montant) throws RemoteException;
}