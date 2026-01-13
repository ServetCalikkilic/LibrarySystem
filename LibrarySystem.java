
import java.util.List;

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
            if (borrowedBook1 instanceof IBorrowable) {
                System.out.println("Status of B001 after borrow: " + ((IBorrowable) borrowedBook1).getStatus());
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
            if (returnedBook1 instanceof IBorrowable) {
                System.out.println("Status of B001 after return: " + ((IBorrowable) returnedBook1).getStatus());
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
            if (bookB001 instanceof IBorrowable) {
                System.out.println("Status of B001 after MEM001 (borrower) was removed: " + ((IBorrowable)bookB001).getStatus());
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
                if (b001 instanceof IBorrowable && ((IBorrowable)b001).getStatus().equals("Borrowed")) {
                    System.out.println("Note: B001 is still 'Borrowed' despite member removal. Manually setting to Available for cleanup.");
                    ((IBorrowable)b001).returnItem(); // Manually make it available if necessary for other tests
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
