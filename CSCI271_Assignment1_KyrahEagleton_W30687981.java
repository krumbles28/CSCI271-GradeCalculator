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
      for (int i = 1; i < studentData.size(); i++){
        int totalA = 0;
        int totalT = 0;
        int totalM =Integer.parseInt(studentData.get(i)[15]);
        int totalF = Integer.parseInt(studentData.get(i)[16]);
        double totalfin = 0;
        char letterG; 

        for (int j = 1; j < 8; j++){
          totalA = Integer.parseInt(studentData.get(i)[j]) + totalA;
          
        }
        totalA = totalA / 7;
        for (int t = 8; t < 15; t++){
          totalT = Integer.parseInt(studentData.get(i)[t]) + totalT;
        }
        totalT = totalT/7;
        double E = ((totalF *.4) + (totalM*.2) + (totalT *.1))/70;
        if( E < .6 ) {
          totalfin = E;
        } else {
          
        }
      

        System.out.println(studentData.get(i)[0] + "'s final grade is " + totalfin);
      }
       
       testReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("file not found");
    }
   
  }
  
}