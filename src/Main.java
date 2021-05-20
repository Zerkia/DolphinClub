public class Main {

  public static void main(String[] args) {
    MedlemsListe medlemsListe = new MedlemsListe();
    Klub klub = new Klub(medlemsListe);
    klub.run();
  }

}