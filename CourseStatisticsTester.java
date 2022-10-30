import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
/**
 * File: CourseStatisticsTester.java
 * This is a tester class for CourseStatistics.
 * @author Tarek Solamy (Alsolame)
 * @version 1.0 5/4/2022
 */


public class CourseStatisticsTester{
  public static void main (String [] args){
    if (args.length !=1){
      System.out.println("Error: You need to provide a file name.");
      System.exit(1);
    }

    CourseStatistics sample= new CourseStatistics();
    Course courseToBeAdded= new Course();
    int counter=0; // counter to keep to track to which method to use for each line
    try {
      FileReader inFile = new FileReader (args[0]);
      BufferedReader in= new BufferedReader (inFile);
      String line;
      while((line = in.readLine()) != null){
        if (counter==0){
           courseToBeAdded.setName(line);
           counter++;
         } else if (counter==1){
           courseToBeAdded.setTitle(line);
           counter++;
         }
         else if (counter==2){
           int students= Integer.parseInt(line);
           courseToBeAdded.setStudents(students);
           counter++;
         }
         else if (counter==3){
           int votes= Integer.parseInt(line);
           courseToBeAdded.setVotes(votes);
           sample.addCourse(courseToBeAdded);
           courseToBeAdded= new Course();
           counter=0;
         }
      }
      } catch (FileNotFoundException e){
        System.out.println("Error: File " + args [0] + "not found.");
        System.exit(1);
      } catch (IOException e){
        System.out.println(e);
        System.exit(1);
      }

      System.out.println("*** Displaying courses and their full descriptions...");

      sample.displayAll();

      System.out.println("*** Displaying courses sorted by their recommendation rates...");
      sample.displayStats();

      Scanner scan= new Scanner(System.in);
      System.out.println("*** Looking up courses...");
      String option1="";
      do {
          System.out.println("Enter a course ID to look up statistics. Enter 's' to stop.");
          System.out.print("Course ID: ");
          option1= scan.next();
          if (sample.getCourse(option1)!=null && !option1.equals("s")){
            System.out.println(sample.getCourse(option1).description());
          } else if (sample.getCourse(option1)==null && !option1.equals("s")){
            System.out.println("No such course! Try again.");
          }
      } while (!option1.equals("s"));

      System.out.println("*** Comparing courses...");
      String option2="";
      List <Course> comparing= new LinkedList <Course>();
      do {
          System.out.println("Enter course IDs to compare. Enter 's' to stop.");
          System.out.print("Course ID: ");
          option2=scan.next();
          if (sample.getCourse(option2)!=null && !option2.equals("s")){
            comparing.add(sample.getCourse(option2));
          } else if (sample.getCourse(option2)==null && !option2.equals("s")){
            System.out.println("No such course! Try again.");
          }
      } while (!option2.equals("s"));
      System.out.print("Best course to take: ");
      if (comparing.size()>1){
        sample.findBest(comparing);
      } else {
        System.out.println("You did not enter enough courses for comparison.");
      }
  }
}
