package bmsbackend;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookYourMovieSystem system = new BookYourMovieSystem();

        while (true) {
            System.out.println("\n=== BookYourTicket Menu ===");
            System.out.println("1. List Movies");
            System.out.println("2. List Theaters by City");
            System.out.println("3. Show all (City-Theater-Movie-Show)");
            System.out.println("4. Book Seats");
            System.out.println("5. Cancel ticket");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        system.displayMovies();
                        break;
                    case "2":
                        System.out.print("Enter city: ");
                        String city = sc.nextLine().trim();
                        system.displaytheater(city);
                        break;
                    case "3":
                        system.displayAllShows();
                        break;

                    case "4":
                        System.out.print("Enter your user_id: ");
                        int userId = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Enter show_id: ");
                        int showId = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Enter seats (comma separated, e.g. A1,A2): ");
                        String seatLine = sc.nextLine().trim();
                        List<String> seats = Arrays.asList(seatLine.split("\\s*,\\s*"));
                        system.displaybookticket(userId, showId, seats);
                        break;
                    case "5":
                        System.out.println("Enter Booking ID to cancel:");
                        int bookingid = sc.nextInt();
                        system.cancelticket(bookingid);
                        break;

                    case "6":
                        System.out.println("Bye!");
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice, try again.");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid number input. Try again.");
            }
        }
    }
}
