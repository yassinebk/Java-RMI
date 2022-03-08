public class Personne implements java.io.Serializable {
    String nom;
    String prenom;
    int age;

    Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Nom " + prenom + " Prenom " + prenom + " Age" + age;
    }

}
