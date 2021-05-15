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
    for (int i = 0; i < load.size(); i+=8) {
      String fetchName = load.get(i);
      int fetchAge = Integer.parseInt(load.get(i+1));
      String fetchAgeGroup = load.get(i+2);
      String fetchStatus = load.get(i+3);
      String fetchSwimType = load.get(i+4);
      int fetchPrice = Integer.parseInt(load.get(i+5));
      String fetchTime = load.get(i+6);

      exerciseSwimmers.add(new MotionistSvømmer(fetchName, fetchAge, fetchAgeGroup, fetchStatus, fetchSwimType, fetchPrice, fetchTime));
    }

    return exerciseSwimmers;
  }

  public ArrayList<KonkurrenceSvømmer> loadCompetetiveSwimmer() {

    ArrayList<String> load = memberFiles.readCompetetiveSwimmers();
    ArrayList<KonkurrenceSvømmer> competetiveSwimmers = new ArrayList<>();
    //fails if motionstSvømmer.txt is empty, if load.size() <= 0 didn't work.
    //maybe a throw needed?
    for (int i = 0; i < load.size(); i+=14) {
      String fetchName = load.get(i);
      int fetchAge = Integer.parseInt(load.get(i+1));
      String fetchAgeGroup = load.get(i+2);
      String fetchStatus = load.get(i+3);
      String fetchSwimType = load.get(i+4);
      int fetchPrice = Integer.parseInt(load.get(i+5));
      String fetchTime = load.get(i+6);
      String fetchDiscipline = load.get(i+7);
      String fetchPersonalBest = load.get(i+8);
      String fetchDate = load.get(i+9);
      String fetchEvent = load.get(i+10);
      int fetchPlacement = Integer.parseInt(load.get(i+11));
      String fetchEventTime = load.get(i+12);

      competetiveSwimmers.add(new KonkurrenceSvømmer(fetchName, fetchAge, fetchAgeGroup, fetchStatus, fetchSwimType, fetchPrice, fetchTime, fetchDiscipline, fetchPersonalBest, fetchDate, fetchEvent, fetchPlacement, fetchEventTime));
    }

    return competetiveSwimmers;
  }

  public String findAgeGroup(int age){
    if (age < 18){
      String ageGroup = "Junior Svømmer";
      return ageGroup;

    } else if (age > 60){
      String ageGroup = "Pensionist Svømmer";
      return ageGroup;
    } else {
      String ageGroup = "Senior Svømmer";
      return ageGroup;
    }
  }
  public int findPrice(String ageGroup){
    if (ageGroup.equals("Junior Svømmer")){
      return 1000;
    } else if(ageGroup.equals("Senior Svømmer")){
      return 1600;
    } else {
      return 1200;
    }
  }
  public int findStatus(String swimStatus, int price){
    if (swimStatus.equals("Active") || swimStatus.equals("Aktiv")){
      return price;
    } else {
      return 500;
    }
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

    String ageGroup = findAgeGroup(age);
    int tempPrice = findPrice(ageGroup);
    int price = findStatus(swimStatus, tempPrice);

    if (swimType.equals("Competetive") || swimType.equals("Konkurrence")) {
      // Spørg om mere
      swimType = "Konkurrence";
      swimStatus = "Aktiv";

      System.out.println(
              "Due to having picked \'Competetive\' / \'Konkurrence\', your status has been set to \'Active\' / \'Aktiv\'");
      System.out.print("Enter Discipline: ");
      String discipline = scan.nextLine();

      System.out.print("Enter Personal best (lap record) (Minute(s)): ");
      int personalBestMinute = scan.nextInt();

      System.out.print("Enter Personal best (lap record) (Second(s)): ");
      int personalBestSecond = scan.nextInt();
      scan.nextLine();

      String personalBest = personalBestMinute + ":" + personalBestSecond;

      System.out.print("Enter date of Personal best (F.x. 27/6/2021): ");
      String date = scan.nextLine();

      /**System.out.println("Enter Personal best (lap record)");
       String personalBest = scan.nextLine();
       LocalTime timePersonalBest = LocalTime.parse(personalBest, formatTiming);
       System.out.println("Enter date of Personal best");
       String date = scan.nextLine();
       LocalDate timeDate = LocalDate.parse(date, formatDating);
       */

      System.out.print("Enter event name (if any, otherwise type \'none\'): ");
      String event = scan.nextLine();

      if(event.equals("none")){
        return new KonkurrenceSvømmer(name, age, ageGroup, swimStatus, swimType, price,
                formattedDate, discipline, personalBest,
                date, "no events", 0, "no events");
      } else {
        System.out.print("Enter Placement of event (F.x. \'1\', not \'1st\': ");
        int eventPlacement = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter date of event (F.x. 27/6/2021): ");
        String eventDate = scan.nextLine();

        return new KonkurrenceSvømmer(name, age, ageGroup, swimStatus, swimType, price,
                formattedDate, discipline, personalBest,
                date, event, eventPlacement, eventDate);
      }
    } else {
      return new MotionistSvømmer(name, age, ageGroup, swimStatus, swimType, price, formattedDate);
    }
  }

  void run(){
    Medlem addMember = createNewMember();
    if(addMember.getSwimType().equals("Konkurrence")){
      competetiveSwimmers.add((KonkurrenceSvømmer) addMember);
      memberFiles.saveCompetetiveSwimmer(competetiveSwimmers);
    } else {
      exerciseSwimmers.add((MotionistSvømmer) addMember);
      memberFiles.saveExerciseSwimmer(exerciseSwimmers);
    }
  }

  public static void main(String[] args) { new Main().run(); }
}