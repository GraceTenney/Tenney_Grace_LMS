import java.util.Scanner;
/*
Grace Tenney
CEN-3024C-31950
5/18/2024
Software Development

Manages console input and output. Creates the menu and accepts char inputs.
Accepts and validates integers.
 */
public class ConsoleIO {
    public static final Scanner input = new Scanner(System.in);
    public static char menu() {
        //menu
        //Creates the menu
        //Takes no arguments
        //Returns a char
        System.out.println("Choose one:\n1. Upload text file library" +
                    "\n--Books are formatted like so:\nId, Title, Author\nId, Title, Author\netc..." +
                    "\n2. Remove book by id" +
                    "\n3. Show Book collection" +
                    "\n4. Quit");
        String response = input.nextLine();
        if(!response.isEmpty()) {
            return response.charAt(0);
        }
        return 'f';
    }

    /**
     * message - prints a String in console and waits until the user presses enter to continue
     * @param mess String to be printed
     */
    public static void message(String mess) {
        //message
        //Outputs a message and waits for the user to press enter
        //to continue
        //Takes a String
        //Returns nothing
        System.out.println(mess);
        System.out.println("\nPress enter to continue.");
        input.nextLine();
    }

    /**
     * getInt - Displays a message in console and creates a loop
     * until an integer is given by the user
     * @param mess String to display
     * @return int - Integer retrieved from user
     */
    public static int getInt(String mess) {
        //getInt
        //Takes a String
        //Returns an int
        int result = 0;
        boolean badInput = true;
        while(badInput) {
            System.out.println(mess);
            char output = input.nextLine().charAt(0);
            if (Character.isDigit(output)) {
                result = Integer.parseInt("" + output);
                badInput = false;
            } else {
                System.out.println("Input must be an integer.");
            }
        }
        return result;
    }
}
