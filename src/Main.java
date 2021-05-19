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
  public String findSwimStatus(Scanner scan, int swimStatusChoice){
    System.out.print("Enter Swimmer status:\n" +
                    "1. Passive\n" +
                    "2. Active\n");
    String swimStatus = "";
    swimStatusChoice = scan.nextInt();

    while(swimStatus == ""){
      switch(swimStatusChoice){
        case 1:
          swimStatus = "Passive";
          break;
        case 2:
          swimStatus = "Active";
          break;
        default:
          System.out.println("Please choose either 1 or 2");
          swimStatusChoice = scan.nextInt();
      }
    }
    scan.nextLine();

    return swimStatus;
  }
  public String findSwimType(Scanner scan,int swimTypeChoice) {
    System.out.print("Enter your type of Swimmer:\n" +
            "1. Exerciser\n" +
            "2. Competetive\n");
    String swimType = "";
    swimTypeChoice = scan.nextInt();
    while (swimType == "") {
      switch (swimTypeChoice) {
        case 1:
          swimType = "Motionist";
          break;
        case 2:
          swimType = "Konkurrence";
          break;
        default:
          System.out.println("Please choose either 1 or 2");
          swimTypeChoice = scan.nextInt();
      }
    }
    scan.nextLine();
    return swimType;
  }
  public String findDiscipline(Scanner scan, int disChoice){
    System.out.println(
        "Due to having picked \'Competetive\' / \'Konkurrence\', your status has been set to \'Active\' / \'Aktiv\'");
    System.out.print("Enter DisciplineSorter: \n" +
                    "1. Butterfly\n" +
                    "2. Freestyle\n" +
                    "3. Backstroke\n" +
                    "4. Breaststroke\n");
    String discipline = "";
    disChoice = scan.nextInt();
    while(discipline == ""){
      switch(disChoice){
        case 1:
          discipline = "Butterfly";
          break;
        case 2:
          discipline = "Freestyle";
          break;
        case 3:
          discipline = "Backstroke";
          break;
        case 4:
          discipline = "Breaststroke";
          break;
        default:
          System.out.println("Please choose a number between 1 and 4");
          disChoice = scan.nextInt();
      }
    }
    scan.nextLine();
    return discipline;
  }
  public String findPersonalBest(Scanner scan, int personalBestMinute, int personalBestSecond){
    while(personalBestMinute < 0 || personalBestSecond < 0) {
      if(personalBestMinute<0) {
        System.out.print("Enter Personal best (lap record) (Minute(s)): ");
        personalBestMinute = scan.nextInt();
      } else if(personalBestSecond<0) {
        System.out.print("Enter Personal best (lap record) (Second(s)): ");
        personalBestSecond = scan.nextInt();

      }
      scan.nextLine();
    }
    return personalBestMinute + ":" + personalBestSecond;

  }

  public int findEventPlacement(Scanner scan, int eventPlacement){
    while(eventPlacement <1) {
      System.out.print("Enter Placement of event (F.x. \'1\', not \'1st\': ");
      eventPlacement = scan.nextInt();

    }
    scan.nextLine();
    return eventPlacement;
  }
  public String findDate(Scanner scan, String eventDate){
    while(!eventDate.matches(("\\d{2}-\\d{2}-\\d{4}"))) {
      System.out.print("Enter date of event (F.x. 27-06-2021): ");
      eventDate = scan.nextLine();
    }
    return eventDate;

  }

  public Medlem createNewMember(){
    Scanner scan = new Scanner(System.in);
    LocalDateTime time = LocalDateTime.now();
    DateTimeFormatter formatDating = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String formattedDate = time.format(formatDating);

    System.out.print("Enter name: ");
    String name = scan.nextLine();

    System.out.print("Enter age: ");
    int age = scan.nextInt();
    scan.nextLine();
    
    String swimStatus = findSwimStatus(scan,0);

    String swimType = findSwimType(scan,0);

    String ageGroup = findAgeGroup(age);
    int tempPrice = findPrice(ageGroup);
    int price = findStatus(swimStatus, tempPrice);

    if (swimType.equals("Konkurrence")) {
      swimStatus = "Aktiv";
      price = findStatus(swimStatus, tempPrice);
      String discipline = findDiscipline(scan,0);
      String personalBest = findPersonalBest(scan,-1,-1);

      String date = findDate(scan,"");

      System.out.print("Enter event name (if any, otherwise type \'none\'): ");
      String event = scan.nextLine();

      if(event.equals("none")){
        return new KonkurrenceSvømmer(name, age, ageGroup, swimStatus, swimType, price,
            formattedDate, discipline, personalBest,
            date, "no event participations", 0, "no event participations");
      } else {
        int eventPlacement = findEventPlacement(scan,-0);
        String eventDate = findDate(scan,"");

        return new KonkurrenceSvømmer(name, age, ageGroup, swimStatus, swimType, price,
            formattedDate, discipline, personalBest,
            date, event, eventPlacement, eventDate);
      }
    } else {
      return new MotionistSvømmer(name, age, ageGroup, swimStatus, swimType, price, formattedDate);
    }
  }

  public void deleteExerciseSwimmer(){
    System.out.print("Please enter a number to remove the corresponding order number: ");
    Scanner scan = new Scanner(System.in);
    int removalInt = scan.nextInt()-1;

    //failsafe
    if(removalInt < 0){
      removalInt = 0;
    } else if (removalInt > exerciseSwimmers.size()) {
      removalInt = exerciseSwimmers.size()-1;
    }
    exerciseSwimmers.remove(removalInt);
  }

  public void deleteCompetetiveSwimmer(){
    System.out.print("Please enter a number to remove the corresponding order number: ");
    Scanner scan = new Scanner(System.in);
    int removalInt = scan.nextInt()-1;

    //failsafe
    if(removalInt < 0){
      removalInt = 0;
    } else if (removalInt > competetiveSwimmers.size()) {
      removalInt = competetiveSwimmers.size()-1;
    }
    competetiveSwimmers.remove(removalInt);
  }

  public void viewExerciseSwimmer(){
    for (int i = 0; i < exerciseSwimmers.size(); i++) {
      System.out.println(exerciseSwimmers.get(i));
    }
  }

  public void viewCompetetiveSwimmers(){
    for (int i = 0; i < competetiveSwimmers.size(); i++) {
      System.out.println(competetiveSwimmers.get(i));
    }
  }

  public void sortCompetetiveSwimmers(){
    competetiveSwimmers.sort(new PersonalBestSorter());
    memberFiles.saveCompetetiveSwimmer(competetiveSwimmers);
    
  }
  public void sortCompetetiveSwimmersDiscipline(){
    competetiveSwimmers.sort(new DisciplineSorter());
  }

  void run(){
    DisplayMenu displayMenu =
        new DisplayMenu(
          "Menu:",
          "Please choose option: ",
          new String[] {
          "1. Create new member",
          "2. Delete exercise swimmer",
          "3. Delete competetive swimmer",
          "4. View exercise swimmers",
          "5. View competetive swimmers",
          "6. View all swimmers",
          "7. View top 5 junior butterfly times",
          "8. View top 5 junior freestyle times",
          "9. View top 5 junior backstroke times",
          "10. View top 5 junior breaststroke times",
          "11. View top 5 senior butterfly times",
          "12. View top 5 senior freestyle times",
          "13. View top 5 senior backstroke times",
          "14. View top 5 senior breaststroke times",
          "15. Quit"
          });

    displayMenu.printMenu();
    boolean isRunning = true;

    while(isRunning){
      int choice = displayMenu.readChoice();
      switch (choice) {
        case 1:
          Medlem addMember = createNewMember();
          if(addMember.getSwimType().equals("Konkurrence")){
            competetiveSwimmers.add((KonkurrenceSvømmer) addMember);
          } else {
            exerciseSwimmers.add((MotionistSvømmer) addMember);
          }
          displayMenu.printMenu();
          break;

        case 2:
          deleteExerciseSwimmer();
          displayMenu.printMenu();
          break;

        case 3:
          deleteCompetetiveSwimmer();
          displayMenu.printMenu();
          break;

        case 4:
          viewExerciseSwimmer();
          displayMenu.printMenu();
          break;

        case 5:
          viewCompetetiveSwimmers();
          displayMenu.printMenu();
          break;

        case 6:
          viewExerciseSwimmer();
          viewCompetetiveSwimmers();
          displayMenu.printMenu();
          break;

        case 7:
          //View top 5 junior butterfly times
          sortCompetetiveSwimmers();
          sortCompetetiveSwimmersDiscipline();
          printSwimmers(0,"Butterfly","Junior Svømmer");
          displayMenu.printMenu();
          break;

        case 8:
          //View top 5 junior freestyle times
          sortCompetetiveSwimmers();
          sortCompetetiveSwimmersDiscipline();
          printSwimmers(0,"Freestyle","Junior Svømmer");
          displayMenu.printMenu();
          break;

        case 9:
          //View top 5 junior backstroke times
          sortCompetetiveSwimmers();
          sortCompetetiveSwimmersDiscipline();
          printSwimmers(0,"Backstroke","Junior Svømmer");
          displayMenu.printMenu();
          break;

        case 10:
          //View top 5 junior breaststroke times
          sortCompetetiveSwimmers();
          sortCompetetiveSwimmersDiscipline();
          printSwimmers(0,"Breaststroke","Junior Svømmer");
          displayMenu.printMenu();
          break;

        case 11:
          //View top 5 senior butterfly times
          sortCompetetiveSwimmers();
          sortCompetetiveSwimmersDiscipline();
          printSwimmers(0,"Butterfly","Senior Svømmer");
          displayMenu.printMenu();
          break;

        case 12:
          //View top 5 senior freestyle times
          sortCompetetiveSwimmers();
          sortCompetetiveSwimmersDiscipline();
          printSwimmers(0,"Freestyle","Senior Svømmer");
          displayMenu.printMenu();
          break;

        case 13:
          //View top 5 senior backstroke times
          sortCompetetiveSwimmers();
          sortCompetetiveSwimmersDiscipline();
          printSwimmers(0,"Backstroke","Senior Svømmer");
          displayMenu.printMenu();
          break;

        case 14:
          //View top 5 senior breaststroke times
          sortCompetetiveSwimmers();
          sortCompetetiveSwimmersDiscipline();
          printSwimmers(0,"Breaststroke","Senior Svømmer");
          displayMenu.printMenu();
          break;

        case 15:
          isRunning = false;
          break;

        default:
          System.out.println("Please input one of the numbers on the screen please.");
      }
    }
    memberFiles.saveCompetetiveSwimmer(competetiveSwimmers);
    memberFiles.saveExerciseSwimmer(exerciseSwimmers);
  }
  public void printSwimmers(int j, String discipline, String ageGroup){
    for(int i = 0; i<competetiveSwimmers.size(); i++) {

      if(competetiveSwimmers.get(i).getDiscipline().equals(discipline) &&
              competetiveSwimmers.get(i).getAgeGroup().equals(ageGroup) && j<5) {
        System.out.println(competetiveSwimmers.get(i).getName() + " " + competetiveSwimmers.get(i).getDiscipline() +
                " " + competetiveSwimmers.get(i).getPersonalBest() + " " + competetiveSwimmers.get(i).getAgeGroup());
        j++;
      }
    }

  }

  public static void main(String[] args) { new Main().run(); }

}