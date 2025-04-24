import java.util.*;

public class Member extends User {
    private List<Book> borrowed;

    public Member(String name, String password) {
        super(name, password);
        this.borrowed = new ArrayList<>();
    }

    @Override
    public void showMenu(List<Book> books, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Üye Menüsü ---");
            System.out.println("1. Kitapları Listele");
            System.out.println("2. Kitap Ödünç Al");
            System.out.println("3. Kitap İade Et");
            System.out.println("4. Aldığım Kitaplar");
            System.out.println("0. Çıkış");

            System.out.print("Seçim: ");
            int sec = Integer.parseInt(scanner.nextLine());

            switch (sec) {
                case 1 -> books.forEach(System.out::println);
                case 2 -> {
                    System.out.print("Kitap adı: ");
                    String title = scanner.nextLine();
                    for (Book book : books) {
                        if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                            book.borrow();
                            borrowed.add(book);
                            System.out.println("Kitap ödünç alındı.");
                            break;
                        }
                    }
                }
                case 3 -> {
                    System.out.print("İade edilecek kitap: ");
                    String title = scanner.nextLine();
                    Iterator<Book> iterator = borrowed.iterator();
                    while (iterator.hasNext()) {
                        Book b = iterator.next();
                        if (b.getTitle().equalsIgnoreCase(title)) {
                            b.returnBook();
                            iterator.remove();
                            System.out.println("İade edildi.");
                            break;
                        }
                    }
                }
                case 4 -> borrowed.forEach(System.out::println);
                case 0 -> { return; }
                default -> System.out.println("Geçersiz seçim.");
            }
        }
    }
}