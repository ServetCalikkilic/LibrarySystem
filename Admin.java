import java.util.List;
import java.util.Scanner;

public class Admin extends User {

    public Admin(String name, String password) {
        super(name, password);
    }

    @Override
    public void showMenu(List<Book> books, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Admin Menüsü ---");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitap Sil");
            System.out.println("3. Kitapları Listele");
            System.out.println("0. Çıkış");

            System.out.print("Seçim: ");
            int sec = Integer.parseInt(scanner.nextLine());

            switch (sec) {
                case 1 -> {
                    System.out.print("Kitap adı: ");
                    String title = scanner.nextLine();
                    System.out.print("Yazar: ");
                    String author = scanner.nextLine();
                    System.out.print("Stok: ");
                    int stock = Integer.parseInt(scanner.nextLine());
                    books.add(new Book(title, author, stock));
                    System.out.println("Kitap eklendi.");
                }
                case 2 -> {
                    System.out.print("Silinecek kitap adı: ");
                    String title = scanner.nextLine();
                    books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
                    System.out.println("Kitap silindi (varsa).");
                }
                case 3 -> books.forEach(System.out::println);
                case 0 -> { return; }
                default -> System.out.println("Geçersiz seçim.");
            }
        }
    }
}