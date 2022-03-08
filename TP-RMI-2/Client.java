import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    private Client() {
    }

    public static void main(String[] args) throws MalformedURLException, NotBoundException {
        try {
            // IHello stub = (IHello) Naming.lookup("rmi://localhost:1099/HH");
            IBanque stub = (IBanque) Naming.lookup("rmi://localhost:1099/Banque");
            Personne myPerson = new Personne("Belkhadem", "Yassine", 20);
            // String response = stub.sayHello();
            // String responsePersonne = stub.sayHelloPersonne(myPerson);
            // System.out.println("response" + response);
            // System.out.println("response 2 \t " + responsePersonne);
            Compte monCompte = stub.creerCompte(myPerson, 0);
            Compte autreCompte = stub.creerCompte(new Personne("Other", "Ben Other", 20), 1000);
            String response = stub.etatDeCompte(monCompte);
            System.out.println("response: " + response);
            stub.transfertEntreCompte(autreCompte, monCompte, 500);
            System.out.println(stub.etatDeCompte(monCompte));
            System.out.println(stub.etatDeCompte(autreCompte));

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
    }

}
