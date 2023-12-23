import menu.EnrollMenu;
import utility.SecurityContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean flag = true;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter current date:(yyyy-MM-dd)");
            String userInput = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                LocalDate localDate = LocalDate.parse(userInput, formatter);
                SecurityContext.fillDateContext(localDate);
                flag = false;
                EnrollMenu enrollMenu = new EnrollMenu();
                enrollMenu.showMenu();
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
            }
        } while (flag);
    }
}
