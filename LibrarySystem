/**
 * @author: Servet Çalikkılıç
 * @date: 18.05.2025
 * @version: 2.0
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


interface Borrowable {
    void borrowItem();
    void returnItem();
    String getStatus();
}

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

class Book extends Media implements Borrowable{
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

class Movie extends Media implements Borrowable {
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

class MusicAlbum extends Media implements Borrowable {
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

class Member{
    String memberId;
    String firstName;
    String lastName;
    ArrayList<Borrowable> borrowedMediaItems;

    public Member(String memberId, String firstName, String lastName) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.borrowedMediaItems = new ArrayList<>();
    }

    public void borrowMedia(Borrowable media){
        getBorrowedMediaItems().add(media);
    }

    public void returnMedia(Borrowable media){
        getBorrowedMediaItems().remove(media);
    }

    public String toString(){
        if (borrowedMediaItems.isEmpty()){
            return "Member ID: " + getMemberId() + ", Name: " + getFirstName() + " " + getLastName() +  "\n Borrowed Items: None";
        }
        else {
            return "Member ID: " + getMemberId() + ", Name: " + getFirstName() + " " + getLastName() +  "\n Borrowed Items: " + getBorrowedMediaItems();
        }
    }

    public String getMemberId() {
        return memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Borrowable> getBorrowedMediaItems() {
        return borrowedMediaItems;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBorrowedMediaItems(ArrayList<Borrowable> borrowedMediaItems) {
        this.borrowedMediaItems = borrowedMediaItems;
    }
}

class MediaNotFoundException extends Exception{
    public MediaNotFoundException(String msg){
        super(msg);
    }
}

class MemberNotFoundException extends Exception{
    public MemberNotFoundException(String msg){
        super(msg);
    }
}

class CannotBorrowException extends Exception{
    public CannotBorrowException(String msg){
        super(msg);
    }
}

class CannotReturnException extends Exception{
    public CannotReturnException(String msg){
        super(msg);
    }
}

class MediaAlreadyExistsException extends Exception{
    public MediaAlreadyExistsException(String msg){
        super(msg);
    }
}

class MemberAlreadyExistsException extends Exception{
    public MemberAlreadyExistsException(String msg){
        super(msg);
    }
}

class LibraryManagement{
    private HashMap<String, Media> mediaCollection;
    private HashMap<String, Member> memberList;

    public LibraryManagement() {
        mediaCollection = new HashMap<>();
        memberList = new HashMap<>();
    }

    public void addMedia(Media mediaItem) throws MediaAlreadyExistsException{
        if (mediaCollection.containsKey(mediaItem.getId())){
            throw new MediaAlreadyExistsException("Error: Media with ID " + mediaItem.getId() + " already exists.");
        }
        System.out.println("Info: Media added successfully: " + mediaItem.getTitle() + " (ID: " + mediaItem.getId() + ")");
        mediaCollection.put(mediaItem.getId(), mediaItem);
    }

    public void removeMedia(String mediaId) throws MediaNotFoundException{
        if (!mediaCollection.containsKey(mediaId)){
            throw new MediaNotFoundException("Error: Media with ID " + mediaId + " not found for removal.");
        }
        Media toRemove = mediaCollection.get(mediaId);
        for (Member member : memberList.values()) {
            member.getBorrowedMediaItems().remove(toRemove);
        }
        System.out.println("Info: Media removed successfully: " +
                findMediaById(mediaId).getTitle() + " (ID: " +
                findMediaById(mediaId).getId() + ")");
        mediaCollection.remove(mediaId, findMediaById(mediaId));
    }

    public Media findMediaById(String mediaId) throws MediaNotFoundException{
        if (!mediaCollection.containsKey(mediaId)){
            throw new MediaNotFoundException("Error: Media with ID " + mediaId + " not found.");
        }
        return mediaCollection.get(mediaId);
    }

    public ArrayList<Media> findMediaByTitle(String title){
        ArrayList <Media> arr = new ArrayList<>();

        for (Media media : mediaCollection.values()){
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())){
                arr.add(media);
            }
        }
        return arr;
    }

    public void addMember(Member member) throws MemberAlreadyExistsException{
        if (memberList.containsKey(member.getMemberId())){
            throw new MemberAlreadyExistsException("Error: Member with ID " + member.getMemberId() + " already exists.");
        }
        System.out.println("Info: Member added successfully: " + member.getFirstName() + " " + member.getLastName() + " (ID: " + member.getMemberId() + ")");
        memberList.put(member.getMemberId(), member);
    }

    public void removeMember(String memberId) throws MemberNotFoundException{
        if (!memberList.containsKey(memberId)){
            throw new MemberNotFoundException("Error: Member with ID " + memberId + " not found for removal.");
        }
        Member member = findMemberById(memberId);
        if (!member.borrowedMediaItems.isEmpty()){
            System.out.println("Warning: Member " + memberId +
                    " has " + member.borrowedMediaItems.size() +
                    " borrowed items. These should ideally be returned before removing the member.");

            System.out.println("Info: Member removed successfully: ID " + memberId);
            memberList.remove(memberId);
        }
        else {
            memberList.remove(memberId);
            System.out.println("Info: Member removed successfully: ID " + memberId);
        }
    }

    public Member findMemberById(String memberId) throws MemberNotFoundException{
        if (!memberList.containsKey(memberId)){
            throw new MemberNotFoundException("Error: Member with ID " + memberId + " not found.");
        }
        return memberList.get(memberId);

    }

    public void processBorrow(String mediaId, String memberId) throws MediaNotFoundException,
            MemberNotFoundException, CannotBorrowException{
        Media mediaItem = findMediaById(mediaId);
        Member member = findMemberById(memberId);

        if (!(mediaItem instanceof Borrowable)){
            throw new CannotBorrowException("Error: Media item '" +
                    findMediaById(mediaId).getTitle() + "' (ID: " +
                    findMediaById(mediaId).getId() + ") is currently not available. Status: Borrowed.");
        }

        Borrowable item = (Borrowable) mediaItem;

        if (!item.getStatus().equals("Available")){
            throw new CannotBorrowException("Error: Media item '" +
                    findMediaById(mediaId).getTitle() + "' (ID: " +
                    findMediaById(mediaId).getId() + ") is currently not available. Status: Borrowed.");
        }

        System.out.println("Info: Media '" + findMediaById(mediaId).getTitle() +
                "' (ID: " + findMediaById(mediaId).getId() + ") successfully borrowed by member " +
                findMemberById(memberId).getFirstName() + " (ID: " +
                findMemberById(memberId).getMemberId() + ").");
        item.borrowItem();
        member.borrowMedia(item);


    }

    public void processReturn(String mediaId, String memberId) throws MediaNotFoundException, MemberNotFoundException, CannotReturnException{
        Media media = findMediaById(mediaId);
        Member member = findMemberById(memberId);

        if (!(media instanceof Borrowable)){
            throw new CannotReturnException("Error: Member " +
                    member.getFirstName() + " (ID: " + memberId +
                    ") did not borrow media item '" +
                    media.getTitle() + "' (ID: " + mediaId + ").");
        }

        Borrowable item = (Borrowable) media;

        if (!member.getBorrowedMediaItems().contains(media) || !item.getStatus().equals("Borrowed")){
            throw new CannotReturnException("Error: Member " +
                    member.getFirstName() + " (ID: " + memberId +
                    ") did not borrow media item '" +
                    media.getTitle() + "' (ID: " + mediaId + ").");
        }
        System.out.println("Info: Media '" + findMediaById(mediaId).getTitle() +
                "' (ID: " + findMediaById(mediaId).getId() +
                ") successfully returned by member " + findMemberById(memberId).getFirstName() +
                " (ID: " + findMemberById(memberId).getMemberId() + ").");
        item.returnItem();
        member.returnMedia(item);
    }

    public void listAllMedia(){
        if (mediaCollection.isEmpty()){
            System.out.println("Info: No media items currently in the library.");
            return;
        }
        System.out.println("\n--- Listing All Media Items (" + mediaCollection.size() + ") ---");
        for (Media media : mediaCollection.values()){
            System.out.println(media);
        }
        System.out.println("--- End of Media List ---");
    }

    public void listAllMembers(){
        if (memberList.isEmpty()){
            System.out.println("Info: No members currently registered in the library.");
            return;
        }
        System.out.println("\n--- Listing All Members (" + memberList.size() + ") ---");
        for (Member member : memberList.values()){
            System.out.println(member);
        }
        System.out.println("--- End of Member List ---");
    }

    public void listMemberBorrowedItems(String memberId) throws MemberNotFoundException{
        if (!memberList.containsKey(memberId)){
            throw new MemberNotFoundException("Error: Member with ID " + memberId + " not found.");
        }
        System.out.println("\n--- Borrowed Items for Member: " +
                findMemberById(memberId).getFirstName() + " " +
                findMemberById(memberId).getLastName() +
                " (ID: " + findMemberById(memberId).getMemberId() + ") ---");
        Member member = findMemberById(memberId);
        if (member.getBorrowedMediaItems().isEmpty()){
            System.out.println("No items currently borrowed by this member.");
        }
        else {
            for (int i=0; i<member.getBorrowedMediaItems().size(); i++){
                System.out.println("- " + member.borrowedMediaItems.get(i));
            }
        }
        System.out.println("--- End of Borrowed Items List for Member " + memberId + " ---");
    }
}


public class LibrarySystem {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();
        System.out.println("--- Library Management System Test Suite ---");
        System.out.println("--- Current Date: " + java.time.LocalDate.now() + " ---\n");


        // Test 1: Adding Media Items
        System.out.println("--- Test 1: Adding Media Items ---");
        try {
            Book book1 = new Book("B001", "The Lord of the Rings", 1954, "J.R.R. Tolkien", "0618260274", 1178);
            Movie movie1 = new Movie("M001", "Inception", 2010, "Christopher Nolan", 148, "Sci-Fi");
            MusicAlbum album1 = new MusicAlbum("A001", "Dark Side of the Moon", 1973, "Pink Floyd", 10, "Progressive Rock");
            Book book2 = new Book("B002", "1984", 1949, "George Orwell", "9780451524935", 328);

            library.addMedia(book1);
            library.addMedia(movie1);
            library.addMedia(album1);
            library.addMedia(book2);

            System.out.println("\n--- Attempting to add existing media (B001), expecting MediaAlreadyExistsException ---");
            library.addMedia(new Book("B001", "Duplicate Book", 2000, "Test Author", "123", 100)); // Should throw exception
        } catch (MediaAlreadyExistsException e) {
            System.err.println("CAUGHT EXPECTED EXCEPTION: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("UNEXPECTED EXCEPTION during media addition: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        library.listAllMedia();

        // Test 2: Adding Members
        System.out.println("\n--- Test 2: Adding Members ---");
        try {
            Member member1 = new Member("MEM001", "John", "Doe");
            Member member2 = new Member("MEM002", "Jane", "Smith");
            library.addMember(member1);
            library.addMember(member2);

            System.out.println("\n--- Attempting to add existing member (MEM001), expecting MemberAlreadyExistsException ---");
            library.addMember(new Member("MEM001", "Johnny", "Doeman")); // Should throw exception
        } catch (MemberAlreadyExistsException e) {
            System.err.println("CAUGHT EXPECTED EXCEPTION: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("UNEXPECTED EXCEPTION during member addition: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        library.listAllMembers();

        // Test 3: Finding Media by ID
        System.out.println("\n--- Test 3: Finding Media by ID ---");
        try {
            System.out.println("Finding B001: " + library.findMediaById("B001").getDetails());
            System.out.println("Finding M001: " + library.findMediaById("M001").getDetails());
            System.out.println("\n--- Attempting to find non-existent media (X999), expecting MediaNotFoundException ---");
            library.findMediaById("X999"); // Should throw exception
        } catch (MediaNotFoundException e) {
            System.err.println("CAUGHT EXPECTED EXCEPTION: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("UNEXPECTED EXCEPTION during findMediaById: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Test 4: Finding Member by ID
        System.out.println("\n--- Test 4: Finding Member by ID ---");
        try {
            System.out.println("Finding MEM001: " + library.findMemberById("MEM001").getFirstName());
            System.out.println("\n--- Attempting to find non-existent member (XMEM9), expecting MemberNotFoundException ---");
            library.findMemberById("XMEM9"); // Should throw exception
        } catch (MemberNotFoundException e) {
            System.err.println("CAUGHT EXPECTED EXCEPTION: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("UNEXPECTED EXCEPTION during findMemberById: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Test 5: Finding Media by Title
        System.out.println("\n--- Test 5: Finding Media by Title ---");
        System.out.println("Searching for 'Lord':");
        List<Media> foundByTitle = library.findMediaByTitle("Lord");
        if (foundByTitle.isEmpty()) System.out.println("Info: No media found with title containing 'Lord'.");
        else foundByTitle.forEach(m -> System.out.println("- " + m.getDetails()));

        System.out.println("\nSearching for 'NonExistentTitle':");
        foundByTitle = library.findMediaByTitle("NonExistentTitle");
        if (foundByTitle.isEmpty()) System.out.println("Info: No media found with title containing 'NonExistentTitle'.");
        else foundByTitle.forEach(m -> System.out.println("- " + m.getDetails()));


        // Test 6: Processing Borrows
        System.out.println("\n--- Test 6: Processing Borrows ---");
        try {
            System.out.println("MEM001 attempting to borrow B001 (The Lord of the Rings):");
            library.processBorrow("B001", "MEM001");
            library.listMemberBorrowedItems("MEM001");
            // Check status directly from the retrieved media object
            Media borrowedBook1 = library.findMediaById("B001");
            if (borrowedBook1 instanceof Borrowable) {
                System.out.println("Status of B001 after borrow: " + ((Borrowable) borrowedBook1).getStatus());
            }


            System.out.println("\nMEM002 attempting to borrow M001 (Inception):");
            library.processBorrow("M001", "MEM002");
            library.listMemberBorrowedItems("MEM002");

            System.out.println("\n--- Attempting to borrow already borrowed item (B001 by MEM002), expecting CannotBorrowException ---");
            library.processBorrow("B001", "MEM002"); // Should throw exception
        } catch (CannotBorrowException e) {
            System.err.println("CAUGHT EXPECTED EXCEPTION: " + e.getMessage());
        } catch (MediaNotFoundException | MemberNotFoundException e) {
            System.err.println("UNEXPECTED ERROR during borrow tests: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        try {
            System.out.println("\n--- Attempting to borrow non-existent media (X999 by MEM001), expecting MediaNotFoundException ---");
            library.processBorrow("X999", "MEM001"); // Should throw exception
        } catch (MediaNotFoundException e) {
            System.err.println("CAUGHT EXPECTED EXCEPTION: " + e.getMessage());
        } catch (MemberNotFoundException | CannotBorrowException e) {
            System.err.println("UNEXPECTED ERROR during borrow non-existent media test: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        try {
            System.out.println("\n--- Attempting to borrow by non-existent member (B002 by XMEM9), expecting MemberNotFoundException ---");
            library.processBorrow("B002", "XMEM9"); // Should throw exception
        } catch (MemberNotFoundException e) {
            System.err.println("CAUGHT EXPECTED EXCEPTION: " + e.getMessage());
        } catch (MediaNotFoundException | CannotBorrowException e) {
            System.err.println("UNEXPECTED ERROR during borrow by non-existent member test: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Test 7: Processing Returns
        System.out.println("\n--- Test 7: Processing Returns ---");
        try {
            System.out.println("MEM001 attempting to return B001 (The Lord of the Rings):");
            library.processReturn("B001", "MEM001");
            library.listMemberBorrowedItems("MEM001");
            Media returnedBook1 = library.findMediaById("B001");
            if (returnedBook1 instanceof Borrowable) {
                System.out.println("Status of B001 after return: " + ((Borrowable) returnedBook1).getStatus());
            }

            System.out.println("\n--- Attempting to return item not borrowed by member (M001 by MEM001), expecting CannotReturnException ---");
            library.processReturn("M001", "MEM001"); // Should throw exception
        } catch (CannotReturnException e) {
            System.err.println("CAUGHT EXPECTED EXCEPTION: " + e.getMessage());
        } catch (MediaNotFoundException | MemberNotFoundException e) {
            System.err.println("UNEXPECTED ERROR during return tests: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        try {
            System.out.println("\n--- Attempting to return an already available/returned item (B001 by MEM001 again), expecting CannotReturnException ---");
            library.processReturn("B001", "MEM001"); // Should throw exception
        } catch (CannotReturnException e) {
            System.err.println("CAUGHT EXPECTED EXCEPTION: " + e.getMessage());
        } catch (MediaNotFoundException | MemberNotFoundException e) {
            System.err.println("UNEXPECTED ERROR during return already available item test: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        try {
            System.out.println("\n--- MEM002 returns M001 (Inception) ---");
            library.processReturn("M001", "MEM002");
            library.listMemberBorrowedItems("MEM002");
        } catch (Exception e) { // Catch generic Exception for unexpected issues in this valid step
            System.err.println("UNEXPECTED ERROR during valid return of M001 by MEM002: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }


        // Test 8: Removing Media
        System.out.println("\n--- Test 8: Removing Media ---");
        try {
            System.out.println("Removing A001 (Dark Side of the Moon):");
            library.removeMedia("A001"); // This was added and not borrowed
            library.listAllMedia();

            System.out.println("\n--- Attempting to remove non-existent media (X999), expecting MediaNotFoundException ---");
            library.removeMedia("X999"); // Should throw exception
        } catch (MediaNotFoundException e) {
            System.err.println("CAUGHT EXPECTED EXCEPTION: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("UNEXPECTED EXCEPTION during media removal: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        System.out.println("\n--- Test 8.1: Attempting to remove a borrowed item and its consequences ---");
        try {
            System.out.println("MEM001 borrows B002 (1984).");
            library.processBorrow("B002", "MEM001");
            library.listMemberBorrowedItems("MEM001");
            System.out.println("Attempting to remove B002 (which is now borrowed by MEM001)...");
            library.removeMedia("B002");
            System.out.println("B002 removed. Current state of media and member MEM001's borrowed items:");
            library.listAllMedia();
            library.listMemberBorrowedItems("MEM001"); // B002 should be gone from here too if removeMedia handled it
        } catch (Exception e) {
            System.err.println("EXCEPTION during borrow or removal of B002: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }


        // Test 9: Removing Members
        System.out.println("\n--- Test 9: Removing Members ---");
        try {
            System.out.println("MEM001 borrows B001 again for member removal test.");
            library.processBorrow("B001", "MEM001");
        } catch (Exception e) {
            System.err.println("Error during pre-setup for member removal test (borrowing B001): " + e.getMessage());
        }

        try {
            System.out.println("Attempting to remove member MEM001 (John Doe) who has borrowed B001:");
            library.removeMember("MEM001");
            library.listAllMembers();
            Media bookB001 = library.findMediaById("B001"); // This will fail if B001 was borrowed by removed member and not auto-returned and media itself not removed
            if (bookB001 instanceof Borrowable) {
                System.out.println("Status of B001 after MEM001 (borrower) was removed: " + ((Borrowable)bookB001).getStatus());
            }


            System.out.println("\nRemoving member MEM002 (Jane Smith - no borrowed items):");
            library.removeMember("MEM002");
            library.listAllMembers();

            System.out.println("\n--- Attempting to remove non-existent member (XMEM9), expecting MemberNotFoundException ---");
            library.removeMember("XMEM9"); // Should throw exception
        } catch (MemberNotFoundException e) {
            System.err.println("CAUGHT EXPECTED EXCEPTION: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("UNEXPECTED EXCEPTION during member removal: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Test 10: Listing with Empty or Near-Empty Collections
        System.out.println("\n--- Test 10: Listing with Empty/Near-Empty Collections ---");
        try {
            System.out.println("Removing any remaining media and members for empty list tests...");
            if (mediaCollectionContains(library, "B001")) {
                Media b001 = library.findMediaById("B001");
                if (b001 instanceof Borrowable && ((Borrowable)b001).getStatus().equals("Borrowed")) {
                    System.out.println("Note: B001 is still 'Borrowed' despite member removal. Manually setting to Available for cleanup.");
                    ((Borrowable)b001).returnItem(); // Manually make it available if necessary for other tests
                }
                library.removeMedia("B001");
            }
            if (mediaCollectionContains(library, "M001")) library.removeMedia("M001");

        } catch (Exception e) {
            System.err.println("Error during cleanup for empty list tests: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        library.listAllMedia();
        library.listAllMembers();


        System.out.println("\n--- Test Suite Completed ---");
    }

    // Helper method to check if media exists without throwing an exception internally for the test suite
    private static boolean mediaCollectionContains(LibraryManagement lib, String mediaId) {
        try {
            lib.findMediaById(mediaId);
            return true;
        } catch (MediaNotFoundException e) {
            return false;
        }
    }
}
