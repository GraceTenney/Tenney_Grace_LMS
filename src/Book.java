/*
Grace Tenney
CEN-3024C-31950
5/18/2024
Software Development

Manages individual books. Most book related methods are here.
 */
public class Book {
    private int id = 0;
    private String title = "";
    private String author = "";

    public Book(String string) {
        //Book constructor
        //Creates a book with a raw string from the text
        //Takes 1 String
        //Technically returns nothing
        String[] var = string.split(",");
        if(var.length == 3) {
            setId(var[0]);
            setTitle(var[1]);
            setAuthor(var[2]);
        }
    }

    /**
     * isValid - checks if a Book has valid parameters
     * for all fields
     * @return boolean
     */
    public boolean isValid() {
        //isValid
        //Checks if a book has values for all variables
        //No arguments
        //Returns a boolean
        boolean result = false;
        if(this.id != 0 && !this.title.isEmpty() && !this.author.isEmpty()) {
            result = true;
        }
        return result;
    }

    /**
     * equals - Checks if two books are the same based on their
     * ID and Title.
     * @param book Takes another Book object as an argument
     * @return boolean
     */
    public boolean equals(Book book) {
        //equals
        //Checks if two books are the same, used to ensure books are unique
        //Sometimes authors write more than one book.
        //Takes a Book
        //Returns a boolean
        return this.id == book.id || this.title.equals(book.title);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        //setId (overloaded)
        //Setter for id
        //Takes int
        //Returns nothing
        this.id = id;
    }

    public void setId(String id) {
        //setId (overloaded)
        //Setter for id, allowing int validation to happen here
        //Takes a String and turns it to an int
        //Returns nothing
        try {
            this.id = Integer.parseInt(id);
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid id.");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "\nID " + id +
                "\nTitle " + title +
                "\nAuthor " + author;
    }
}
