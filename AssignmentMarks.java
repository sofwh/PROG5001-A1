
/**
 * Write a description of class AssignmentMarks here.
 *
 * @author (Sirjan Baniya)
 * @version (5/09/2023)
 */

import java.util.Scanner;
public class AssignmentMarks
{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double[] marks = new double[30];

        // F1: Allows the user to input the name of the assignment.
        System.out.print("Please enter the name of the assignment: ");
        String assignmentName = input.nextLine();

        // F2: Allows the user to input individual student marks for the assignment.
        for (int i = 0; i < marks.length; i++) {
            boolean isValid = false;
            while (!isValid) {

                System.out.print("Please input the mark for student " + (i + 1) + " (0-30): ");
                double mark = input.nextDouble();
                input.nextLine(); 

                //F3:  Input Validation and Error Messages
                if (mark >= 0 && mark <= 30) {
                    marks[i] = mark;
                    isValid = true;
                } else {
                    System.out.println("Invalid input! The mark should be between 0 and 30.");
                }

            }
        }

        // F4: Prints the assignment name and the entered student marks on the screen.
        System.out.println("\n--- Assignment Statistics ---");
        System.out.println(" Assignment Name: " +  " --- " +assignmentName+ " --- ");
        System.out.print("Entered Marks : ");
        for (double mark : marks) {
            System.out.print(mark + " | ");
        }
        System.out.println();
    }
}