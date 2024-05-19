import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Grace Tenney
CEN-3024C-31950
5/18/2024
Software Development

Manages file input and output. Can open file choosing prompts.
 */
public class FileIO {
    private static Path path = Paths.get("./example.txt");
    private static File file = path.toFile();
    public static final JFileChooser fc = new JFileChooser();

    /**
     * initialize - Initializes the example .txt file within the project. <br>
     * Output file: <br>
     * 1,To Kill a Mockingbird,Harper Lee<br>
     * 2,1984,George Orwell<br>
     * 3,The Great Gatsby,F. Scott Fitzgerald<br>
     */
    public static void initialize() {
        //initialize
        //initializes the example textfile
        //Takes no arguments
        //Returns nothing
        try {
            if(Files.notExists(path))
                Files.createFile(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] people = {"1,To Kill a Mockingbird,Harper Lee",
                "2,1984,George Orwell",
                "3,The Great Gatsby,F. Scott Fitzgerald"};
        try {
            Writer output = new FileWriter(file);
            for(String s : people) {
                output.write(s + "\n");
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * read - creates a String from selected .txt file.
     * @return String from .txt file selected by various means, such as JFileChooser
     */
    public static String read() {
        //read
        //Reads the selected file and returns a String based on the contents
        //Takes no arguments
        //Returns String
        String result = " ";
        try {
            result = Files.readString(file.toPath());
        } catch (IOException e) {

        }
        return result;
    }

    /**
     * chooseFile - Opens a file chooser for the user using JFileChooser
     * @return the return state of the file chooser on popdown from 1-3:
     * <ul><li>CANCEL</li>
     * <li>APPROVE</li><li>ERROR</li></ul>
     */
    public static int chooseFile() {
        //chooseFile
        //Opens a file chooser for the user and returns an int for
        //the option chosen
        //Takes no arguments
        //Returns nothing
        fc.setFileSelectionMode(0);
        int option = fc.showOpenDialog(null);
        if(option == 0) {
            String result = fc.getSelectedFile().getPath();
            if (result.substring(result.lastIndexOf("."), result.length()).equals(".txt"))
                file = fc.getSelectedFile();
            else
                ConsoleIO.message("Incorrect file type, must be a txt file.");
            System.out.println(file);
        }
        return option;
    }
}
