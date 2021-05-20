import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Klub {
    private MedlemsListe medlemsListe;

    public Klub(MedlemsListe medlemsListe){
        this.medlemsListe = medlemsListe;
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
                    medlemsListe.createNewMember();
                    displayMenu.printMenu();
                    break;

                case 2:
                    medlemsListe.deleteExerciseSwimmer();
                    displayMenu.printMenu();
                    break;

                case 3:
                    medlemsListe.deleteCompetetiveSwimmer();
                    displayMenu.printMenu();
                    break;

                case 4:
                    medlemsListe.viewExerciseSwimmer();
                    displayMenu.printMenu();
                    break;

                case 5:
                    medlemsListe.viewCompetetiveSwimmers();
                    displayMenu.printMenu();
                    break;

                case 6:
                    case6Response();
                    displayMenu.printMenu();
                    break;

                case 7:
                    //View top 5 junior butterfly times
                    case7Response();
                    displayMenu.printMenu();
                    break;

                case 8:
                    //View top 5 junior freestyle times
                    case8Response();
                    displayMenu.printMenu();
                    break;

                case 9:
                    //View top 5 junior backstroke times
                    case9Response();
                    displayMenu.printMenu();
                    break;

                case 10:
                    //View top 5 junior breaststroke times
                    case10Response();
                    displayMenu.printMenu();
                    break;

                case 11:
                    //View top 5 senior butterfly times
                    case11Response();
                    displayMenu.printMenu();
                    break;

                case 12:
                    //View top 5 senior freestyle times
                    case12Response();
                    displayMenu.printMenu();
                    break;

                case 13:
                    //View top 5 senior backstroke times
                    case13Response();
                    displayMenu.printMenu();
                    break;

                case 14:
                    //View top 5 senior breaststroke times
                    case14Response();
                    displayMenu.printMenu();
                    break;

                case 15:
                    isRunning = false;
                    break;

                default:
                    System.out.println("Please input one of the numbers on the screen please.");
            }
        }


    }
    public void case6Response(){
        medlemsListe.viewExerciseSwimmer();
        medlemsListe.viewCompetetiveSwimmers();
    }
    public void case7Response() {
        medlemsListe.sortCompetetiveSwimmers();
        medlemsListe.sortCompetetiveSwimmersDiscipline();
        medlemsListe.printSwimmers(0,"Butterfly","Junior Svømmer");
    }
    public void case8Response(){
        medlemsListe.sortCompetetiveSwimmers();
        medlemsListe.sortCompetetiveSwimmersDiscipline();
        medlemsListe.printSwimmers(0,"Freestyle","Junior Svømmer");
    }

    public void case9Response(){
        medlemsListe.sortCompetetiveSwimmers();
        medlemsListe.sortCompetetiveSwimmersDiscipline();
        medlemsListe.printSwimmers(0,"Backstroke","Junior Svømmer");
    }

    public void case10Response(){
        medlemsListe.sortCompetetiveSwimmers();
        medlemsListe.sortCompetetiveSwimmersDiscipline();
        medlemsListe.printSwimmers(0,"Breaststroke","Junior Svømmer");
    }
    public void case11Response(){
        medlemsListe.sortCompetetiveSwimmers();
        medlemsListe.sortCompetetiveSwimmersDiscipline();
        medlemsListe.printSwimmers(0,"Butterfly","Senior Svømmer");
    }
    public void case12Response(){
        medlemsListe.sortCompetetiveSwimmers();
        medlemsListe.sortCompetetiveSwimmersDiscipline();
        medlemsListe.printSwimmers(0,"Freestyle","Senior Svømmer");
    }
    public void case13Response(){
        medlemsListe.sortCompetetiveSwimmers();
        medlemsListe.sortCompetetiveSwimmersDiscipline();
        medlemsListe.printSwimmers(0,"Backstroke","Senior Svømmer");
    }
    public void case14Response(){
        medlemsListe.sortCompetetiveSwimmers();
        medlemsListe.sortCompetetiveSwimmersDiscipline();
        medlemsListe.printSwimmers(0,"Breaststroke","Senior Svømmer");
    }

}
