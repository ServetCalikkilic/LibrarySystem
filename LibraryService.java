import java.util.*;

public class LibraryService {
    private List<Book> books;
    private List<User> users;

    public LibraryService() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }


    public void addBook(String title, String author, int stock){
        Book book = new Book(title, author, stock);
    }

    public void addAdmin(String name, String password){
        Admin admin = new Admin(name, password);
    }

    public void addMember(String name, String password){
        Member member = new Member(name, password);
    }

    public void loadSampleData() {
        books.add(new Book("Sefiller", "Victor Hugo", 3));
        books.add(new Book("Suç ve Ceza", "Dostoyevski", 2));
        users.add(new Admin("Admin","123"));
        users.add(new Member("Ayşe", "111"));
    }
}