import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
/**
 * File: CourseStatistics.java
 *This class maintains the course statistics
 *@author Tarek Solamy (Alsolame)
 *@version 1.0 5/4/2022
 */

public class CourseStatistics{
  private Map <String , Course> storage;
  private PriorityQueue<Course> recommendation;
  private int totalCourses;
  private CourseComparator comp;

  /**Default Constructor for the Course class */
  public CourseStatistics(){
  storage= new HashMap<>();
  comp=new CourseComparator();
  }

  /** This method adds a course c if it not yet stored or to update its totals it if is
   *Time Complexity: O(1)
   */
  public void addCourse(Course c){
      if(storage.containsKey(c.getName())){ // if it continues, the course info will be updated
        c.setStudents(c.getStudents()+storage.get(c.getName()).getStudents());
        c.setVotes(c.getVotes()+storage.get(c.getName()).getVotes());
        storage.put(c.getName(),c);
      } else{                        // otherwise, the course will be added as it is
        storage.put(c.getName(),c);
        ++totalCourses;
      }
    }
  /** This method finds the course given its name
   *@return the course that has the given name, otherwise null
   *Time Complexity: O(1)
   */
  public Course getCourse(String name){
      return storage.get(name);
    }

    /** This method find and display the best course to take based on its recommendation score
     *@return the title of the course
     *Time Complexity: O(nlogn) ----- where n is the size of the list courses
     */
    public void findBest(List<Course> courses){
      recommendation=new PriorityQueue<Course>(comp);  // PriorityQueue is Instantiated
      recommendation.addAll(courses);  // add all elements in list to the PriorityQueue
      System.out.print(recommendation.poll().description()); // pick the head of the queue since it has the highest percentage
    }
    /** to display all course names and their recommendation scores sorted by the scores.
     *Time Complexity: O(n)
     */
    public void displayStats(){
      recommendation=new PriorityQueue<Course>(comp);  // new PriorityQueue Instantiated with compartor to be sorted accordingly
    for (Map.Entry<String , Course> entry: storage.entrySet()){
      recommendation.add(entry.getValue());                           // courses are added to entry
      }
      while (recommendation.size()!=0){
        System.out.println(recommendation.poll().toString());       // after being sorted in PriorityQueue, they are printed
      }
    }
    /** This method displays all courses and their descriptions provided by description()
     *Time Complexity: O(n)
     */
    public void displayAll(){
    for (Map.Entry<String , Course> entry: storage.entrySet()){
      System.out.println(entry.getValue().description());
      }
    }
  }
