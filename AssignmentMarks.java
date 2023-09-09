
/**
 * This Java application calculates and displays statistics related to student marks for an assignment
 *
 * @author (Sirjan Baniya)
 * @version (1.1)
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class AssignmentMarks {
    public static void main(String[] args) {
        String assignmentName = getAssignmentName();
        double[] marks = getStudentMarks();
        printAssignmentAndMarks(assignmentName, marks);
        printLowestAndHighestMarks(marks);
        printMeanAndStandardDeviation(marks);
        
    }

    // F1: Get the assignment name
    public static String getAssignmentName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the name of the assignment: ");
        String name = input.nextLine();
        return name;
    }

    // F2 & F3: Get student marks and validate input
    public static double[] getStudentMarks() {
        double[] marks = new double[30];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < marks.length; i++) {
            boolean isValid = false;
            while (!isValid) {
                try {
                    System.out.print("Please input the mark for student no " + (i + 1) + ": ");
                    double mark = input.nextDouble();
                    input.nextLine();  // Clear the buffer
                    if (mark >= 0 && mark <= 30) {
                        marks[i] = mark;
                        isValid = true;
                    } else {
                        System.out.println("Invalid input! The mark should be between 0 and 30.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number for the mark.");
                    input.nextLine(); // Clear the buffer
                }
            }
        }
        return marks;
    }

    // F4: Print the assignment name and student marks
    public static void printAssignmentAndMarks(String assignmentName, double[] marks) {
        System.out.println(" --- Assignment Statistics ---");
        System.out.println(" Assignment Name: " + assignmentName);
        System.out.println("Entered Marks:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Student " + (i + 1) + ": " + marks[i]);
        }
    }

    // F5: Print the lowest and highest marks
    public static void printLowestAndHighestMarks(double[] marks) {
        double leastMark = marks[0];
        double highestMark = marks[0];
        for (double mark : marks) {
            if (mark < leastMark) leastMark = mark;
            if (mark > highestMark) highestMark = mark;
        }
        System.out.println("Lowest Mark: " + leastMark);
        System.out.println("Highest Mark: " + highestMark);
    }

    // F6: Print mean and standard deviation
    public static void printMeanAndStandardDeviation(double[] marks) {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }

        double mean = total / marks.length;
        System.out.printf("Mean Mark: %.2f\n", mean);

        double sumOfSquaredDifferences = 0.0;
        for (double mark : marks) {
            double difference = mark - mean;
            sumOfSquaredDifferences += difference * difference;
        }

        double variance = sumOfSquaredDifferences / marks.length;
        double standardDeviation = Math.sqrt(variance);

        System.out.printf("Standard Deviation: %.2f\n", standardDeviation);
    }
}
