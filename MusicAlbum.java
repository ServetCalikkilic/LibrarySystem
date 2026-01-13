class MusicAlbum extends Media implements IBorrowable {
    private String status;
    private String artist;
    private int trackCount;
    private String albumGenre;

    public MusicAlbum(String id, String title, int publicationYear, String artist, int trackCount, String albumGenre) {
        super(id, title, publicationYear);
        this.status = "Available";
        this.artist = artist;
        this.trackCount = trackCount;
        this.albumGenre = albumGenre;
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
                ", Year: " + getPublicationYear() + ", Artist: " + artist +
                ", Tracks: " + trackCount + ", Genre: " + albumGenre +
                ", Status: " + getStatus();
    }

    @Override
    public String toString(){
        return "ID: " + getId() + ", Title: " + getTitle() +
                ", Year: " + getPublicationYear() + ", Artist: " + artist +
                ", Tracks: " + trackCount + ", Genre: " + albumGenre +
                ", Status: " + getStatus();
    }
}
