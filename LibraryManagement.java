import java.util.ArrayList;
import java.util.HashMap;

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

        if (!(mediaItem instanceof IBorrowable)){
            throw new CannotBorrowException("Error: Media item '" +
                    findMediaById(mediaId).getTitle() + "' (ID: " +
                    findMediaById(mediaId).getId() + ") is currently not available. Status: Borrowed.");
        }

        IBorrowable item = (IBorrowable) mediaItem;

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

        if (!(media instanceof IBorrowable)){
            throw new CannotReturnException("Error: Member " +
                    member.getFirstName() + " (ID: " + memberId +
                    ") did not borrow media item '" +
                    media.getTitle() + "' (ID: " + mediaId + ").");
        }

        IBorrowable item = (IBorrowable) media;

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
