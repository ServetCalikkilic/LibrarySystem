import java.time.LocalDate;

public class BookRecord {
    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BookRecord(Book book) {
        this.book = book;
        this.borrowDate = LocalDate.now();
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate() {
        this.returnDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return book.getTitle() + " | Ödünç: " + borrowDate +
                " | İade: " + (returnDate == null ? "Henüz değil" : returnDate);
    }
}