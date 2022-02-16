import java.rmi.Naming;

public class Server {
    public Server() {
    }

    public static void main(String[] args) {
        try {
            HelloDistant objDistant = new HelloDistant();
            Banque banque = new Banque();
            Naming.rebind("rmi://localhost:1099/HH", objDistant);
            Naming.rebind("rmi://localhost:1099/Banque", banque);

            System.err.println("Server Ready ..");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
