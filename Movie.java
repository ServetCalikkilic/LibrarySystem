class Movie extends Media implements IBorrowable {
    private String status;
    private String director;
    private int durationMinutes;
    private String genre;

    public Movie(String id, String title, int publicationYear, String director, int durationMinutes, String genre) {
        super(id, title, publicationYear);
        this.director = director;
        this.status = "Available";
        this.durationMinutes = durationMinutes;
        this.genre = genre;
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
    String getDetails() {
        return "ID: " + getId() + ", Title: " + getTitle() +
                ", Year: " + getPublicationYear() + ", Director: " + director +
                ", Duration: " + durationMinutes + " min, Genre: " + genre +
                ", Status: " + getStatus();
    }

    @Override
    public String toString(){
        return "ID: " + getId() + ", Title: " + getTitle() +
                ", Year: " + getPublicationYear() + ", Director: " + director +
                ", Duration: " + durationMinutes + " min, Genre: " + genre +
                ", Status: " + getStatus();
    }
}
