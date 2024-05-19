/*
Grace Tenney
CEN-3024C-31950
5/18/2024
Software Development

Library Management Software system that allows the user to mass document books with .txt files,
remove a book by its id, and view the collection of books.
 */

public class main {
    public static void main(String[] args) {
        //main
        //runs the program and menu
        //Takes String[] args
        //Returns nothing
        boolean running = true;
        Collection books = new Collection();
        FileIO.initialize();
        books.upload();
        while(running) {
            boolean badInput = true;
            while(badInput) {
                char output = ConsoleIO.menu();
                switch (output) {
                    case '1':
                        badInput = false;
                        if(FileIO.chooseFile() != 1)
                            books.upload();
                        ConsoleIO.message(books.toString());
                        break;
                    case '2':
                        badInput = false;
                        books.removeById(ConsoleIO.getInt("Enter the id of the book to remove: "));
                        ConsoleIO.message(books.toString());
                        break;
                    case '3':
                        ConsoleIO.message(books.toString());
                        badInput = false;
                        break;
                    case '4':
                        badInput = false;
                        running = false;
                        break;
                    default:
                        ConsoleIO.message("Incorrect input.");
                        break;
                }
            }
        }
    }
}
