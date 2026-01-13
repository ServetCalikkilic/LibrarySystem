import java.util.ArrayList;

class Member{
    String memberId;
    String firstName;
    String lastName;
    ArrayList<IBorrowable> borrowedMediaItems;

    public Member(String memberId, String firstName, String lastName) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.borrowedMediaItems = new ArrayList<>();
    }

    public void borrowMedia(IBorrowable media){
        getBorrowedMediaItems().add(media);
    }

    public void returnMedia(IBorrowable media){
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

    public ArrayList<IBorrowable> getBorrowedMediaItems() {
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

    public void setBorrowedMediaItems(ArrayList<IBorrowable> borrowedMediaItems) {
        this.borrowedMediaItems = borrowedMediaItems;
    }
}
