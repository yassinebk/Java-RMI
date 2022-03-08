import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloDistant extends UnicastRemoteObject implements IHello {

    public HelloDistant() throws RemoteException {
    };

    @Override
    public String sayHello() throws RemoteException {
        return "Hello world !";
    }

    @Override
    public String sayHelloPersonne(Personne person) throws RemoteException {
        // TODO Auto-generated method stub
        return "Hello " + person.nom + " Prenom " + person.prenom + " Age " + person.age;
    }

}
