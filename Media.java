abstract class Media {
    private String id;
    private String title;
    private int publicationYear;

    public Media(String id, String title, int publicationYear) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    abstract String getDetails();

    public String toString(){
        return "Media id: " + getId() + " Media title: " + getTitle() + " Media publication year: " + getPublicationYear();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
