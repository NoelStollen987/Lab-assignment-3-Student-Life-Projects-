import java.util.Scanner;

public class StudyTracker {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        double weekgoal = 10;
        double totstudtime = 0;
        int sescount = 0;
        double progT = 0;
        double mathT = 0;
        double engT = 0;
        double othT = 0;

        while (true) {
            System.out.println("\n===== STUDY TRACKER =====");
            System.out.println("1. Add study session");
            System.out.println("2. View statistics");
            System.out.println("3. Check weekly goal");
            System.out.println("4. Exit");
            System.out.print("\nChoose an option: ");

            int opt = s.nextInt();

            if (opt == 1) {
                System.out.println("\nChoose subject:");
                System.out.println("1. Programming");
                System.out.println("2. Mathematics");
                System.out.println("3. English");
                System.out.println("4. Other");
                System.out.print("\nChoose an opt: ");

                int subjectChoice = s.nextInt();

                if (subjectChoice < 1 || subjectChoice > 4) {
                    System.out.println("Invalid subject choice. Returning to menu.");
                    continue;
                }

                System.out.print("Study time in Hours: ");
                double time = s.nextInt();

                if (time <= 0) {
                    System.out.println("Invalid study time. Time must be greater than 0.");
                    continue;
                }

                if (subjectChoice == 1) {
                    progT = progT + time;
                } else if (subjectChoice == 2) {
                    mathT = mathT + time;
                } else if (subjectChoice == 3) {
                    engT = engT + time;
                } else if (subjectChoice == 4) {
                    othT = othT + time;
                }

                totstudtime = totstudtime + time;
                sescount = sescount + 1;

                System.out.println("\nStudy session added!");
                System.out.println("Current total study time: " + totstudtime + " Hours");

            } else if (opt == 2) {
                System.out.println("\n===== WEEKLY STATISTICS =====");
                System.out.println("Study sessions: " + sescount);
                System.out.println("Total study time: " + totstudtime + " Hours\n");
                System.out.println("Programming: " + progT + " Hours");
                System.out.println("Mathematics: " + mathT + " Hours");
                System.out.println("English: " + engT + " Hours");
                System.out.println("Other: " + othT + " Hours");

            } else if (opt == 3) {
                System.out.println("\nWeekly goal: " + weekgoal + " Hours");
                System.out.println("You studied: " + totstudtime + " Hours");

                if (totstudtime >= weekgoal) {
                    System.out.println("Weekly goal achieved!");
                } else {
                    double remaining = weekgoal - totstudtime;
                    System.out.println("Remaining: " + remaining + " Hours");
                }

            } else if (opt == 4) {
                System.out.println("Study tracker closed. Keep up the good work!");
                break;
            } else {
                System.out.println("Invalid opt. Please try again.");
            }
        }

        s.close();

    }


}