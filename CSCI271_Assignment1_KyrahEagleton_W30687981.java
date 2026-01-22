/*************************************************************************
* Project 1 for CSCI 271-001 Spring 2026
*
* Author: Kyrah Eagleton
* OS: Ubuntu Debian Linux 21.1
* Compiler: javac 25.0.1
* Date: January 21, 2026
*
* Purpose
* This program reads a list of scores from an input file, and puts them 
* through various equations to result in the cummulative grade for said 
* student.
*************************************************************************/

/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* Kyrah Eagleton
* W30687981
********************************************************************/

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;


public class CSCI271_Assignment1_KyrahEagleton_W30687981 {
    
    public static void main(String[] args) {
        try {
           File test = new File("assignment1_data.csv"); // Opens assignment1_data.csv as a file to be worked with
           Scanner testReader = new Scanner(test); //Reads the open file
           ArrayList<String[]> studentData = new ArrayList<>(); // Allows each students data to be held as an array inside of a list that can be parsed through
            /*Reads through the file to  get the student names and grades*/
           while (testReader.hasNextLine()) 
            {
               String line = testReader.nextLine(); // Each line is held in this variable
               String[] lineArry = line.split(","); // Splits each line into an array of data
               studentData.add(lineArry); 
        
           }
           /*Reads through each students info and calculates their grade */
           for (int i = 1; i < studentData.size(); i++)
            {
               int totalA = 0; // Total points gathered through assignments
               int totalT = 0; // Total points gathered through tests
               int totalM =Integer.parseInt(studentData.get(i)[15]); // Holds the midterm grade
               int totalF = Integer.parseInt(studentData.get(i)[16]); // holds the Final exam grade
               double totalfin = 0; //grade affter calculations are finished

               /*reads through the the first 7 numbers in the csv doc
                *and add them together to  find the total ammount of points
                *allotted to the assignment field*/
               for (int j = 1; j < 8; j++)
                {
                   totalA = Integer.parseInt(studentData.get(i)[j]) + totalA;
          
                }
               totalA = totalA / 7;


               /*reads through the the seccond set of 7 numbers in the csv doc
                *and add them together to find the total ammount of points
                *allotted in the Tests field */
               for (int t = 8; t < 15; t++){
                   totalT = Integer.parseInt(studentData.get(i)[t]) + totalT;
               }
               totalT = totalT/7;


               double E = ((totalF *.4) + (totalM*.2) + (totalT *.1))/70; // calculated the E part of the grading equation
               double W = ((E-.6)/20) *.3; // calculates the W part of the grading equation
               
               /*carries out the piecewise fuction used in 
                *this classes grading scheme*/
               if( E < .6 ) 
               {
                   totalfin = E;
               } else if((E <.8 )&&(E >=.6))
               {
                   totalfin = ((1-W)*E) +(W*totalA);
               }else if (E >= .8) 
               {
                   totalfin = ((.4*totalF) + (.2 * totalM) + (.1*totalT) +(.3*totalA))/100;
               }
              
               totalfin =totalfin*100; // converts the percent to a whole number out of 100

               /*assigns a letter grade to each student based on the their final grade */
               if (totalfin >= 90) 
               {
                    System.out.println(studentData.get(i)[0] + "'s final grade is an A");
               } else if (totalfin >= 80) 
               {
                    System.out.println(studentData.get(i)[0] + "'s final grade is a B");
               
               } else if (totalfin >= 70) 
               {
                  System.out.println(studentData.get(i)[0] + "'s final grade is a C");
               } else if (totalfin >= 60)
               {
                  System.out.println(studentData.get(i)[0] + "'s final grade is a D");
               }else 
               {
                  System.out.println(studentData.get(i)[0] + "'s final grade is an F");
               }
               
           }
       
           testReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
   
    }
  
}