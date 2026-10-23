import java.util.Scanner;

public class GradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double assignP = 0;
        int assignC = 0;
        double examP = 0;
        int examC = 0;

        while (true) {
            System.out.println("\n===== SEMESTER GRADE TRACKER =====");
            System.out.println("1. Add assignment result");
            System.out.println("2. Add exam result");
            System.out.println("3. View current grade");
            System.out.println("4. Exit");
            System.out.print("\nChoose an opt: ");

            int opt = scanner.nextInt();
            if (opt == 1) {
                System.out.print("Enter assignment score: ");
                double scA = scanner.nextDouble();

                if (scA < 0 || scA > 100) {
                    System.out.println("Invalid score. Enter a value from 0 to 100.");
                } else {
                    assignP = assignP + scA;
                    assignC = assignC + 1;
                    System.out.println("Assignment score added.");
                }

            } else if (opt == 2) {
                System.out.print("Enter exam score: ");
                double scE = scanner.nextDouble();

                if (scE < 0 || scE > 100) {
                    System.out.println("Invalid score. Enter a value from 0 to 100.");
                } else {
                    examP = examP + scE;
                    examC = examC + 1;
                    System.out.println("Exam score added.");
                }

            } else if (opt == 3) {
                if (assignC == 0 && examC == 0) {
                    System.out.println("\nNo results available yet.");
                    continue;
                }

                System.out.println("\n===== CURRENT RESULTS =====");

                double assignAver = 0;
                double examAver = 0;
                double overAver = 0;
                System.out.println("Assignments completed: " + assignC);
                if (assignC > 0) {
                    assignAver = assignP / assignC;
                    System.out.println("Assignment average: " + assignAver);
                } else {
                    System.out.println("Assignment average: N/A (No entries)");
                }

                System.out.println("\nExams completed: " + examC);
                if (examC > 0) {
                    examAver = examP / examC;
                    System.out.println("Exam average: " + examAver);
                } else {
                    System.out.println("Exam average: N/A (No entries)");
                }
                if (assignC > 0 && examC > 0) {
                    overAver = (assignAver * 0.50) + (examAver * 0.50);
                    System.out.println("\nOverall average: " + overAver);
                } else if (assignC > 0) {
                    overAver = assignAver;
                    System.out.println("\nOverall average (Assignments only): " + overAver);
                } else {
                    overAver = examAver;
                    System.out.println("\nOverall average (Exams only): " + overAver);
                }

                String gr = "";
                if (overAver >= 90) {
                    gr = "A";
                } else if (overAver >= 80) {
                    gr = "B";
                } else if (overAver >= 70) {
                    gr = "C";
                } else if (overAver >= 60) {
                    gr = "D";
                } else {
                    gr = "F";
                }
                System.out.println("Grade: " + gr);

                if (overAver >= 60) {
                    System.out.println("Status: Passing");
                } else {
                    System.out.println("Status: Failing");
                }

            } else if (opt == 4) {
                System.out.println("Grade tracker closed.");
                break;
            } else {
                System.out.println("Invalid opt. Please try again.");
            }
        }

        scanner.close();
    }
}