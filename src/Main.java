import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private static final FileHandler memberFiles = new FileHandler();
  ArrayList<MotionistSvømmer> exerciseSwimmers = loadExerciseSwimmer();
  ArrayList<KonkurrenceSvømmer> competetiveSwimmers = loadCompetetiveSwimmer();

  public ArrayList<MotionistSvømmer> loadExerciseSwimmer() {
    ArrayList<String> load = memberFiles.readExerciserSwimmers();
    ArrayList<MotionistSvømmer> exerciseSwimmers = new ArrayList<>();

    //fails if motionstSvømmer.txt is empty, if load.size() <= 0 didn't work.
    //maybe a throw needed?
    for (int i = 0; i < load.size(); i+=7) {
      String fetchName = load.get(i).substring(7);
      int fetchAge = Integer.parseInt(load.get(i+1).substring(6));
      String fetchAgeGroup = load.get(i+2).substring(12);
      String fetchStatus = load.get(i+3).substring(18);
      int fetchPrice = Integer.parseInt(load.get(i+4).substring(17));
      String fetchTime = load.get(i+5).substring(19);

      exerciseSwimmers.add(new MotionistSvømmer(fetchName, fetchAge, fetchAgeGroup, fetchStatus, fetchPrice, fetchTime));
    }

    return exerciseSwimmers;
  }

  public ArrayList<KonkurrenceSvømmer> loadCompetetiveSwimmer() {
    ArrayList<String> load = memberFiles.readCompetetiveSwimmers();

    //fails if motionstSvømmer.txt is empty, if load.size() <= 0 didn't work.
    //maybe a throw needed?
    for (int i = 0; i < load.size(); i+=12) {
      String fetchName = load.get(i);
      int fetchAge = Integer.parseInt(load.get(i+1));
      String fetchAgeGroup = load.get(i+2);
      int fetchPrice = Integer.parseInt(load.get(i+3));
      String fetchTime = load.get(i+4);
      String fetchDiscipline = load.get(i+5);
      String fetchPersonalBest = load.get(i+6);
      String fetchDate = load.get(i+7);
      String fetchEvent = load.get(i+8);
      int fetchPlacement = Integer.parseInt(load.get(i+9));
      String fetchEventTime = load.get(i+10);

      competetiveSwimmers.add(new KonkurrenceSvømmer(
        fetchName, fetchAge, fetchAgeGroup, fetchPrice, fetchTime,
        fetchDiscipline, fetchPersonalBest, fetchDate, fetchEvent,
        fetchPlacement, fetchEventTime));
    }

    return competetiveSwimmers;
  }

  public Medlem createNewMember(){
    Scanner scan = new Scanner(System.in);
    LocalDateTime time = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd:MM:yyyy");
    String formattedDate = time.format(format);

    System.out.print("Enter name: ");
    String name = scan.nextLine();

    System.out.print("Enter age: ");
    int age = scan.nextInt();
    scan.nextLine();

    System.out.print("Enter Swimmer status (Passive/Active (Passiv/Aktiv): ");
    String swimStatus = scan.nextLine();

    System.out.print("Enter your type of Swimmer (Exerciser/Competetive (Motionist/Konkurrence)): ");
    String swimType = scan.nextLine();

    if (swimType.equals("Competetive") || swimType.equals("Konkurrence")){
      //Spørg om mere
    }

    if (swimStatus.equals("Active") || swimType.equals("Aktiv")){
      swimStatus = "Aktiv";
      if (age < 18){
        String ageGroup = "Junior Svømmer";
        int price = 1000;

        return new MotionistSvømmer(name, age, ageGroup, swimStatus, price, formattedDate);
      } else if (age > 60){
        String ageGroup = "Senior Svømmer";
        int price = 1200;

        return new MotionistSvømmer(name, age, ageGroup, swimStatus, price, formattedDate);
      } else {
        String ageGroup = "Senior Svømmer";
        int price = 1600;

        return new MotionistSvømmer(name, age, ageGroup, swimStatus, price, formattedDate);
      }
    } else {
      swimStatus = "Passiv";
      int price = 500;
      if (age < 18){
        String ageGroup = "Junior Svømmer";

        return new MotionistSvømmer(name, age, ageGroup, swimStatus, price, formattedDate);
      } else{
        String ageGroup = "Senior Svømmer";

        return new MotionistSvømmer(name, age, ageGroup, swimStatus, price, formattedDate);
      }
    }
  }

  void run(){
    createNewMember();
    memberFiles.saveExerciseSwimmer(exerciseSwimmers);
  }

  public static void main(String[] args) { new Main().run(); }
}
