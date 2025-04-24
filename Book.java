public class Book {
    private String title;
    private String author;
    private int stock;

    public Book(String title, String author, int stock) {
        this.title = title;
        this.author = author;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public void borrow() {
        if (isAvailable()) {
            stock--;
        }
    }

    public void returnBook() {
        stock++;
    }

    @Override
    public String toString() {
        return "Kitap: " + title + " | Yazar: " + author + " | Stok: " + stock +
                " | Durum: " + (isAvailable() ? "Müsait" : "Tükendi");
    }
}