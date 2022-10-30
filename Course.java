
/**
 * File: Course.java
 * This class represents an individual Course and its characteristics
 * @author Tarek Solamy (Alsolame)
 * @version 1.0 5/4/2022
 */
public class Course{

  private String name;
  private String title;
  private int students;
  private int votes;
  /**Default Constructor for the Course class */
  public Course(){}

  /**parametrized Constructor for the Course class */
  public Course (String name, String title, int students,  int votes){
    this.name=name;
    this.title=title;
    this.students=students;
    this.votes=votes;
  }
  /** getter method for the name of the course
   *@return the name of the course
   *Time Complexity: O(1)
   */

  public String getName(){
      return name;
  }
  /** getter method for the title of the course
   *@return the title of the course
   *Time Complexity: O(1)
   */

  public String getTitle(){
      return title;
  }
  /** getter method for the number of students in the course
   *@return the number of students in the course
   *Time Complexity: O(1)
   */

  public int getStudents(){
      return students;
  }
  /** getter method for the votes of the course
   *@return the positive votes of the students
   *Time Complexity: O(1)
   */

  public int getVotes(){
      return votes;
  }
  /** setter method for the name of the course
   *@param the name of the course
   *Time Complexity: O(1)
   */

  public void setName(String name){
    this.name=name;
  }
  /** setter method for the title of the course
   *@param the title of the course
   *Time Complexity: O(1)
   */

  public void setTitle(String title){
    this.title=title;
  }
  /** setter method for the number of students in the course
   *@param the number of students in the course
   *Time Complexity: O(1)
   */

  public void setStudents(int students){
    this.students=students;
  }
  /** setter method for the votes of the course
   *@param the positive recommendation votes
   *Time Complexity: O(1)
   */

  public void setVotes(int votes){
    this.votes=votes;
  }
  /**This method calculates and return the recommendation score, the percentage
   * of students who recommend the course
   * @return the recommendation score percentage value
   *Time Complexity: O(1)
   */

  public double getScore(){
    return (((double) votes/(double)students)*100);
  }
  /* This method creates a string of the description of the course
  * @return a String representation of a full course description
  *Time Complexity: O(1)
  */

  public String description(){
    String courseDetails= getName() + ": " + getTitle() + " has been taken by " + getStudents() + " students and has a " + (int) getScore() + " % recommendation score.";
    return courseDetails;
  }
  /**
   *This method creates a string of the name and the sccore of the course
   *@return a String representation consisting of the course name and the recommendation score
   * Time Complexity: O(1)
   */

  public String toString(){
    String courseDetails= getName() + ": " + (int) getScore() + " %. ";
    return courseDetails;

  }
}
