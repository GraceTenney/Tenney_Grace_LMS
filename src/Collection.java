import java.util.ArrayList;
/*
Grace Tenney
CEN-3024C-31950
5/18/2024
Software Development

This class manages the collection, particularly allowing books to be removed by id.
It also creates the ArrayList from the FileIO output.
 */
public class Collection {
    public ArrayList<Book> collection = new ArrayList<Book>();
    /**
     * removeById - Removes a book in the collection with a matching id.
     * @param id id of book to remove
     */
    public void removeById(int id) {
        //Returns nothing
        this.collection.removeIf(b -> b.getId() == id);
    }

    /**
     * upload - uploads file from FileIO to the collection
     */
    public void upload() {
        //upload
        //Reads the selected .txt file, formats it, validates it,
        //and adds it to the collection
        //Takes no arguments
        //Returns nothing
        String[] books = FileIO.read().split("\n");
        ArrayList<Book> result = new ArrayList<Book>();
        Book bookToAdd;
        for (String s : books) {
            bookToAdd = new Book(s);
            if(bookToAdd.isValid()) {
                Book finalBookToAdd = bookToAdd;
                result.removeIf(b -> b.equals(finalBookToAdd));
                this.collection.removeIf(b -> b.equals(finalBookToAdd));
                result.add(bookToAdd);
            }
        }
        this.collection.addAll(result);
    }

    @Override
    public String toString() {
        String result = "";
        for (Book b : collection) {
            result += b.toString();
        }
        return result;
    }
}
