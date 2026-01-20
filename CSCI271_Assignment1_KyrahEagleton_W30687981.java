import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class CSCI271_Assignment1_KyrahEagleton_W30687981 {
  public static void main(String[] args) {
    try {
       File test = new File("assignment1_data.csv");
       Scanner testReader = new Scanner(test);
       ArrayList<String[]> studentData = new ArrayList<>();
       while (testReader.hasNextLine()) {
        String line = testReader.nextLine();
        String[] lineArry = line.split(",");
        studentData.add(lineArry);
        
        
       }
      for (int i = 0; i < studentData.size(); i++){
        System.out.println(studentData.get(i)[0]);
      }
       
       testReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("file not found");
    }
   
  }
  
}