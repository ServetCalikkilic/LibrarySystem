import java.util.*;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Book> books = new ArrayList<>(List.of(
                new Book("Sefiller", "Victor Hugo", 3),
                new Book("Suç ve Ceza", "Dostoyevski", 2)
        ));

        List<User> users = new ArrayList<>(List.of(
                new Admin("Servet", "123"),
                new Member("Ali", "111")
        ));

        System.out.println("=== Kütüphane Sistemi ===");

        while (true) {
            System.out.print("\nKullanıcı Adı: ");
            String name = scanner.nextLine();
            System.out.print("Şifre: ");
            String pw = scanner.nextLine();

            User found = null;
            for (User u : users) {
                if (u.getName().equals(name) && u.checkPassword(pw)) {
                    found = u;
                    break;
                }
            }

            if (found != null) {
                System.out.println("Hoş geldiniz, " + found.getName());
                found.showMenu(books, scanner);
            } else {
                System.out.println("Giriş başarısız.");
            }

            System.out.print("Çıkmak istiyor musunuz? (e/h): ");
            if (scanner.nextLine().equalsIgnoreCase("e")) break;
        }

        scanner.close();
    }
}