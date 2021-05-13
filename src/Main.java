import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
      String fetchName = load.get(i);
      int fetchAge = Integer.parseInt(load.get(i+1));
      String fetchAgeGroup = load.get(i+2);
      String fetchStatus = load.get(i+3);
      int fetchPrice = Integer.parseInt(load.get(i+4));
      String fetchTime = load.get(i+5);

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
      String fetchStatus = load.get(i+3);
      int fetchPrice = Integer.parseInt(load.get(i+4));
      String fetchTime = load.get(i+5);
      String fetchDiscipline = load.get(i+6);
      String fetchPersonalBest = load.get(i+7);
      String fetchDate = load.get(i+8);
      String fetchEvent = load.get(i+9);
      int fetchPlacement = Integer.parseInt(load.get(i+10));
      String fetchEventTime = load.get(i+11);

      competetiveSwimmers.add(new KonkurrenceSvømmer(
        fetchName, fetchAge, fetchAgeGroup, fetchPrice, fetchStatus,
        fetchTime, fetchDiscipline, fetchPersonalBest, fetchDate,
        fetchEvent, fetchPlacement, fetchEventTime));
    }

    return competetiveSwimmers;
  }

  public Medlem createNewMember(){
    Scanner scan = new Scanner(System.in);
    LocalDateTime time = LocalDateTime.now();
    DateTimeFormatter formatDating = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter formatTiming = DateTimeFormatter.ofPattern("mm:ss");
    String formattedDate = time.format(formatDating);

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
      swimStatus = "Aktiv";
      swimType = "Konkurrence";

      System.out.println("Due to having picked \'Competetive\' / \'Konkurrence\', your status has been set to \'Active\' / \'Aktiv\'");
      System.out.println("Enter Discipline");
      String discipline = scan.nextLine();

      /**System.out.println("Enter Personal best (lap record) (Minute(s))");
      int personalBestMinute = scan.nextInt();

      System.out.println("Enter Personal best (lap record) (Second(s))");
      int personalBestSecond = scan.nextInt();

      String personalBest = personalBestMinute + ":" + personalBestSecond;
      */

      System.out.println("Enter Personal best (lap record)");
      String personalBest = scan.nextLine();
      LocalTime timePersonalBest = LocalTime.parse(personalBest, formatTiming);

      System.out.println("Enter date of Personal best");
      String date = scan.nextLine();
      LocalDate timeDate = LocalDate.parse(date, formatDating);

      System.out.println("Enter event name (if any)");
      String event = scan.nextLine();

      System.out.println("Enter Placement of event");
      int eventPlacement = scan.nextInt();

      System.out.println("Enter date of event");
      String eventDate = scan.nextLine();
      LocalDate timeEventDate = LocalDate.parse(eventDate, formatDating);
    }

    //linje 118-150 skal muligvis duplikeres ind i if statementet ovenover -_-
    /**eller..hvis vi på en måde kan rykke den gruppe tekst ovenover den anden
     * kan vi evt. lave et lidt nemmere fiks via en enkelt return statement for hver..
     *bare lige swimStatus der bliver svær er få overført.
     *
     */
    if (swimStatus.equals("Active") || swimStatus.equals("Aktiv")){
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

    exerciseSwimmers.add((MotionistSvømmer) createNewMember());
    memberFiles.saveExerciseSwimmer(exerciseSwimmers);
  }

  public static void main(String[] args) { new Main().run(); }
}
