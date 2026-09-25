import java.util.Scanner;

public class NameValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter full name: ");
        String input = scan.nextLine();

        if (!input.matches("^[a-zA-Z]+ +[a-zA-Z]+$")) {
            System.out.println("Incorrect format for name");
        } else {
            System.out.println("Valid name format.");
        }
        scan.close();
    }
}