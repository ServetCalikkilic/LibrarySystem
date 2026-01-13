class Book extends Media implements IBorrowable{
    private String status;
    private String author;
    private String isbn;
    private int pageCount;

    public Book(String id, String title, int publicationYear, String author, String isbn, int pageCount) {
        super(id, title, publicationYear);
        this.status = "Available";
        this.author = author;
        this.isbn = isbn;
        this.pageCount = pageCount;
    }

    @Override
    public void borrowItem() {

        this.status = "Borrowed";

    }

    @Override
    public void returnItem() {
        this.status = "Available";

    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public String getDetails() {
        return "ID: " + getId() + ", Title: " + getTitle() +
                ", Year: " + getPublicationYear() + ", Author: " + author +
                ", ISBN: " + isbn + ", Pages: " + pageCount +
                ", Status: " + getStatus();
    }

    @Override
    public String toString(){
        return "ID: " + getId() + ", Title: " + getTitle() +
                ", Year: " + getPublicationYear() + ", Author: " + author +
                ", ISBN: " + isbn + ", Pages: " + pageCount +
                ", Status: " + getStatus();
    }
}
