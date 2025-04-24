public abstract class User {
    protected String name;
    protected String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public abstract void showMenu(java.util.List<Book> books, java.util.Scanner scanner);
}