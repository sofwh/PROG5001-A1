
/**
 * Write a description of class AssignmentMarks here.
 *
 * @author (Sirjan Baniya)
 * @version (5/09/2023)
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class AssignmentMarks
{
    public static void main(String[] args) {

        double[] marks = new double[30];
        double leastMark;
        double highestMark;
        double total = 0;
        double mean;

        // F1: Allows the user to input the name of the assignment.
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the name of the assignment: ");
        String assignmentName = input.nextLine();

        // F2: Allows the user to input individual student marks for the assignment.
        for (int i = 0; i < marks.length; i++) {
            boolean isValid = false;
            while (!isValid) {
                try {
                    System.out.print("Please input the mark for student no " + (i + 1) + " : ");
                    double mark = input.nextDouble();
                    input.nextLine(); 

                    //F3:  Input Validation and Error Messages
                    if (mark >= 0 && mark <= 30) {
                        marks[i] = mark;
                        isValid = true;
                    } else {
                        System.out.println("Invalid input! The mark should be between 0 and 30.");

                    }
                }catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number for the mark.");
                    input.nextLine(); // Clear the scanner buffer
                }

            }
        }

        // F4: Prints the assignment name and the entered student marks on the screen.
        System.out.println(" --- Assignment Statistics ---");
        System.out.println(" Assignment Name: "+assignmentName );
        System.out.print("Entered Marks : ");
        System.out.println();
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Student " + (i + 1) + ": " + marks[i]);
        }
        System.out.println();

        // F5: Display the least and highest marks
        leastMark = marks[0];
        highestMark = marks[0];
        for (double mark : marks) {
            if (mark < leastMark) leastMark = mark;
            if (mark > highestMark) highestMark = mark;
        }
        System.out.println("Lowest Mark: " + leastMark);
        System.out.println("Highest Mark: " + highestMark);

        // F6: Calculate and display average and standard deviation
        for (double mark : marks) {
            total += mark;
        }
        mean = total / marks.length;
        System.out.printf("Mean Mark: %.2f\n ", mean);

        //For Standard Deviation
        double sumOfSquaredDifferences = 0.0;
        for (double mark : marks) {
            double difference = mark - mean;
            sumOfSquaredDifferences += difference * difference;
        }

        double variance = sumOfSquaredDifferences / marks.length;
        double standardDeviation = Math.sqrt(variance);

        System.out.printf("Standard Deviation: %.2f\n", standardDeviation);
        // Close scanner to prevent resource leak
        input.close();
    }
}
