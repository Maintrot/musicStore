import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        MusicStore store = new MusicStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Music Store Menu ===");
            System.out.println("1. Add Album");
            System.out.println("2. List Albums");
            System.out.println("3. Find Album");
            System.out.println("4. Remove Album");
            System.out.println("5. Place Order");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter album name: ");
                    String albumName = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artistName = scanner.nextLine();
                    Album album = new Album(albumName, artistName);

                    while (true) {
                        System.out.print("Add a song? (yes/no): ");
                        String answer = scanner.nextLine();
                        if (answer.equalsIgnoreCase("no")) break;

                        System.out.print("Enter song title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter song genre: ");
                        String genre = scanner.nextLine();
                        System.out.print("Enter song duration (minutes): ");
                        double duration = scanner.nextDouble();
                        scanner.nextLine(); // Clear the buffer

                        Song song = new Song(title, genre, duration);
                        album.addSong(song);
                    }
                    store.addAlbum(album);
                    System.out.println("Album added successfully!");
                }
                case 2 -> store.listAlbums();
                case 3 -> {
                    System.out.print("Enter album name to search: ");
                    String searchName = scanner.nextLine();
                    Album foundAlbum = store.findAlbum(searchName);
                    if (foundAlbum != null) {
                        System.out.println("Album found: " + foundAlbum.getName() + " by " + foundAlbum.getArtist());
                        System.out.println("Songs in the album:");
                        for (Song song : foundAlbum.getSongs()) {
                            System.out.println("- " + song.getTitle() + " (" + song.getGenre() + ", " + song.getDuration() + " min)");
                        }
                    } else {
                        System.out.println("Album not found.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter album name to remove: ");
                    String removeName = scanner.nextLine();
                    store.removeAlbum(removeName);
                }
                case 5 -> {
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter your age: ");
                    int customerAge = scanner.nextInt();
                    Customer customer = new Customer(customerName, customerAge);

                    Order order = new Order(customer);
                    while (true) {
                        System.out.print("Enter album name to add to your order (or type 'done' to finish): ");
                        String orderName = scanner.nextLine();
                        if (orderName.equalsIgnoreCase("done")) break;

                        Album orderAlbum = store.findAlbum(orderName);
                        if (orderAlbum != null) {
                            System.out.print("Enter album price: ");
                            int price = scanner.nextInt();
                            scanner.nextLine(); // Clear the buffer
                            order.addAlbum(orderAlbum, price);
                            System.out.println("Album added to your order.");
                        } else {
                            System.out.println("Album not found.");
                        }
                    }
                    System.out.println("Order placed. Total price: $" + order.getTotalPrice());
                }
                case 6 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
// ЗАЧЕМ Я ТАК МНОГО СДЕЛАЛ((((((((((((((((((((
// А ВЕДЬ МОГ ДАЖЕ БЕЗ ЭТОГО ИНТЕРФЕЙСА СДЕЛАТЬ((((((((((