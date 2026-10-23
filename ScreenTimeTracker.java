import java.util.Scanner;

public class ScreenTimeTracker {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int socMedT = 0;
        int gameT = 0;
        int studT = 0;
        int streamT = 0;

        int totScrT = 0;
        int recSess = 0;

        while (true) {
            System.out.println("\n===== SCREEN-TIME TRACKER =====");
            System.out.println("1. Add social media time");
            System.out.println("2. Add gaming time");
            System.out.println("3. Add studying time");
            System.out.println("4. Add video or streaming time");
            System.out.println("5. View statistics");
            System.out.println("6. Exit");
            System.out.print("\nChoose an option: ");

            int opt = s.nextInt();
            if (opt >= 1 && opt <= 4) {
                int min = 0;

                if (opt == 1) {
                    System.out.print("Enter social media minutes: ");
                    min = s.nextInt();
                    if (min > 0) {
                        socMedT = socMedT + min;
                    }
                } else if (opt == 2) {
                    System.out.print("Enter gaming minutes: ");
                    min = s.nextInt();
                    if (min > 0) {
                        gameT = gameT + min;
                    }
                } else if (opt == 3) {
                    System.out.print("Enter studying minutes: ");
                    min = s.nextInt();
                    if (min > 0) {
                        studT = studT + min;
                    }
                } else if (opt == 4) {
                    System.out.print("Enter video or streaming minutes: ");
                    min = s.nextInt();
                    if (min > 0) {
                        streamT = streamT + min;
                    }
                }
                if (min <= 0) {
                    System.out.println("Invalid time. Minutes must be greater than 0.");
                } else {
                    totScrT = totScrT + min;
                    recSess = recSess + 1;
                    System.out.println("Time added successfully!");
                }

            } else if (opt == 5) {
                System.out.println("\n===== TODAY'S SCREEN TIME =====");
                System.out.println("Social media: " + socMedT + " minutes");
                System.out.println("Gaming: " + gameT + " minutes");
                System.out.println("Studying: " + studT + " minutes");
                System.out.println("Streaming: " + streamT + " minutes");
                System.out.println("\nTotal screen time: " + totScrT + " minutes");
                System.out.println("Recorded sessions: " + recSess);
                System.out.println();

                int happyT = socMedT + gameT + streamT;

                if (studT > happyT) {
                    System.out.println("Study screen time is greater than entertainment screen time. Good balance!");
                } else if (happyT > studT) {
                    System.out.println("Entertainment screen time is greater than study time.");
                } else {
                    System.out.println("Study and entertainment screen time are equal.");
                }

                if (totScrT < 120) {
                    System.out.println("Category: Low screen time");
                } else if (totScrT <= 240) {
                    System.out.println("Category: Moderate screen time");
                } else {
                    System.out.println("Category: High screen time");
                }

            } else if (opt == 6) {
                System.out.println("Screen-time tracker closed.");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        s.close();
    }
}