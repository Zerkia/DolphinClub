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
                    medlemsListe.viewExerciseSwimmer();
                    medlemsListe.viewCompetetiveSwimmers();
                    displayMenu.printMenu();
                    break;

                case 7:
                    //View top 5 junior butterfly times
                    medlemsListe.sortCompetetiveSwimmers();
                    medlemsListe.sortCompetetiveSwimmersDiscipline();
                    medlemsListe.printSwimmers(0,"Butterfly","Junior Svømmer");
                    displayMenu.printMenu();
                    break;

                case 8:
                    //View top 5 junior freestyle times
                    medlemsListe.sortCompetetiveSwimmers();
                    medlemsListe.sortCompetetiveSwimmersDiscipline();
                    medlemsListe.printSwimmers(0,"Freestyle","Junior Svømmer");
                    displayMenu.printMenu();
                    break;

                case 9:
                    //View top 5 junior backstroke times
                    medlemsListe.sortCompetetiveSwimmers();
                    medlemsListe.sortCompetetiveSwimmersDiscipline();
                    medlemsListe.printSwimmers(0,"Backstroke","Junior Svømmer");
                    displayMenu.printMenu();
                    break;

                case 10:
                    //View top 5 junior breaststroke times
                    medlemsListe.sortCompetetiveSwimmers();
                    medlemsListe.sortCompetetiveSwimmersDiscipline();
                    medlemsListe.printSwimmers(0,"Breaststroke","Junior Svømmer");
                    displayMenu.printMenu();
                    break;

                case 11:
                    //View top 5 senior butterfly times
                    medlemsListe.sortCompetetiveSwimmers();
                    medlemsListe.sortCompetetiveSwimmersDiscipline();
                    medlemsListe.printSwimmers(0,"Butterfly","Senior Svømmer");
                    displayMenu.printMenu();
                    break;

                case 12:
                    //View top 5 senior freestyle times
                    medlemsListe.sortCompetetiveSwimmers();
                    medlemsListe.sortCompetetiveSwimmersDiscipline();
                    medlemsListe.printSwimmers(0,"Freestyle","Senior Svømmer");
                    displayMenu.printMenu();
                    break;

                case 13:
                    //View top 5 senior backstroke times
                    medlemsListe.sortCompetetiveSwimmers();
                    medlemsListe.sortCompetetiveSwimmersDiscipline();
                    medlemsListe.printSwimmers(0,"Backstroke","Senior Svømmer");
                    displayMenu.printMenu();
                    break;

                case 14:
                    //View top 5 senior breaststroke times
                    medlemsListe.sortCompetetiveSwimmers();
                    medlemsListe.sortCompetetiveSwimmersDiscipline();
                    medlemsListe.printSwimmers(0,"Breaststroke","Senior Svømmer");
                    displayMenu.printMenu();
                    break;

                case 15:
                    isRunning = false;
                    break;

                default:
                    System.out.println("Please input one of the numbers on the screen please.");
            }
            //medlemsListe.saveCompetetive(medlemsListe);
            //medlemsListe.saveExercise(medlemsListe.exerciseSwimmers);
        }

    }

}
