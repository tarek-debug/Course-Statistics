import java.util.Comparator;
/**
 * File: CourseComparator.java
 * This class implements compare() to compare the objects based on their recommendation
 score as provided by getScore()
 * @author Tarek Solamy (Alsolame)
 * @version 1.0 5/4/2022
 */

public class CourseComparator implements Comparator<Course>{

  /** This method prints the elements of an ArrayList L.
  *@param course a, used for the comparison
  *@param course b. used for the comparison
  *@return 1 if b is bigger
  *@return 0 if a and b are equal
  *@return -1 if a is bigger
  *Time Complexity: O(1)
  */
  public int compare(Course a, Course b){
    if(a.getScore()<b.getScore()){
      return 1;
    } else if(a.getScore()==b.getScore()){
      return 0;
    }else{
      return -1;
    }
  }
}
