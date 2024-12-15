import java.util.ArrayList;
import java.util.List;
public class Order {
    private Customer customer;
    private List<Album> albums;
    private int totalPrice;

    public Order(Customer customer) {
        this.customer = customer;
        this.albums = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addAlbum(Album album, int price) {
        albums.add(album);
        totalPrice += price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Album> getAlbums() {
        return albums;
    }
}
