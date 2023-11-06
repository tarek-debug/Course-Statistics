# Course Statistics

## Class Course

The `Course` class represents an individual course object. It includes the following instance variables:

- `String name`: Stores the course name (e.g., CPSC215).
- `String title`: Stores the course title (e.g., Data Structures and Algorithms).
- `int students`: Stores the total number of students who have taken the course.
- `int votes`: Stores the total number of positive recommendation votes.

### Constructors

- Default constructor and a parametrized constructor to set the instance variables.

### Methods

- `double getScore()`: Calculates and returns the recommendation score, which is the percentage of students who recommend the course.
- `String description()`: Returns a String representation of a full course description.
- `String toString()`: Returns a String representation consisting of the course name and the recommendation score.

## Class CourseStatistics

The `CourseStatistics` class maintains course statistics and uses the following data structures:

- A Map implemented with a hash table for storage.
- A PriorityQueue for recommending the best course to take. This queue uses a custom `CourseComparator` object to compare courses.
- It keeps track of the total number of courses added.

### Methods

- `void addCourse(Course c)`: Adds a course `c` if it's not yet stored or updates its totals if it is.
- `Course getCourse(String name)`: Returns a stored course given its name.
- `void findBest(List<Course> courses)`: Finds and displays the best course to take based on its recommendation score.
- `void displayStats()`: Displays all course names and their recommendation scores sorted by the scores.
- `void displayAll()`: Displays all courses and their descriptions provided by `description()`.

## Class CourseStatisticsTester

The `CourseStatisticsTester` class is a tester class for `CourseStatistics`. It produces the expected output as specified in Part 7 of your project requirements. A user can look up and compare any number of courses.

## Class CourseComparator

The `CourseComparator` class implements the `compare()` method to compare objects based on their recommendation score as provided by `getScore()`.

## Usage

To use this project, you can create instances of `Course`, add them to a `CourseStatistics` object, and perform various operations to find and display course statistics. The `CourseStatisticsTester` class demonstrates the project's functionality and expected output.

## Sample Output

You can refer to Part 7 for sample output examples.

## Acknowledgements

Thanks to all contributors for their work on this project.

## License

This project is open-sourced under the MIT license.
