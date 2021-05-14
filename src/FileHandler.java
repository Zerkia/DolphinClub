import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

 public void saveExerciseSwimmer(ArrayList<MotionistSvømmer> exerciseSwimmer) {
  File file = new File("src/MotionistSvømmer.txt");

  try{
   PrintStream save = new PrintStream(file);
   for (int i = 0; i < exerciseSwimmer.size(); i++) {
    save.println(exerciseSwimmer.get(i).getName());
    save.println(exerciseSwimmer.get(i).getAge());
    save.println(exerciseSwimmer.get(i).getAgeGroup());
    save.println(exerciseSwimmer.get(i).getStatus());
    save.println(exerciseSwimmer.get(i).getPrice());
    save.println(exerciseSwimmer.get(i).getTime());
    save.println();
   }
   save.close();
  } catch(FileNotFoundException e) {
   System.out.println("No file found");
  }
 }

 public void saveCompetetiveSwimmer(ArrayList<KonkurrenceSvømmer> competetiveMember) {
  File file = new File("src/KonkurrenceSvømmer.txt");

  try{
   PrintStream save = new PrintStream(file);
   for (int i = 0; i < competetiveMember.size(); i++) {
    save.println(competetiveMember.get(i).getName());
    save.println(competetiveMember.get(i).getAge());
    save.println(competetiveMember.get(i).getAgeGroup());
    save.println(competetiveMember.get(i).getStatus());
    save.println(competetiveMember.get(i).getPrice());
    save.println(competetiveMember.get(i).getTime());
    save.println(competetiveMember.get(i).getDiscipline());
    save.println(competetiveMember.get(i).getPersonalBest());
    save.println(competetiveMember.get(i).getDate());
    save.println(competetiveMember.get(i).getEvent());
    save.println(competetiveMember.get(i).getPlacement());
    save.println(competetiveMember.get(i).getEventDate());
    save.println();
   }
   save.close();
  } catch(FileNotFoundException e) {
   System.out.println("No file found");
  }
 }

 public ArrayList<String> readExerciserSwimmers() {
  File file = new File("src/MotionistSvømmer.txt");
  ArrayList<String> output = new ArrayList<>();

  try{
   Scanner scan = new Scanner(file);
   while (scan.hasNextLine()){
    output.add(scan.nextLine());
   }
  } catch(FileNotFoundException e) {
   System.out.println("No File Found");
  }
  return output;
 }

 public ArrayList<String> readCompetetiveSwimmers() {
  File file = new File("src/KonkurrenceSvømmer.txt");
  ArrayList<String> output = new ArrayList<>();

  try{
   Scanner scan = new Scanner(file);
   while (scan.hasNextLine()){
    output.add(scan.nextLine());
   }
  } catch(FileNotFoundException e) {
   System.out.println("No File Found");
  }
  return output;
 }

}
