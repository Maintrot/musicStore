import java.util.ArrayList;
import java.util.List;
public class MusicStore {
    private List<Album> albums;

    public MusicStore() {
        this.albums = new ArrayList<>();
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public boolean removeAlbum(String name) {
        for (Album album : albums) {
            if (album.getName().equals(name)) {
                albums.remove(album);
                System.out.println("album: " + name + " , has been removed");
                return true;
            }
        }
        System.out.println("album: " + name + " , not found");
        return false;
    }

    public void listAlbums() {
        if (albums.isEmpty()) {
            System.out.println("No almbums here");
        }

        System.out.println("Available albums");
        for (Album album : albums) {
            System.out.println(album.getName() + " by " + album.getArtist());
        }
    }

    public Album findAlbum(String name) {
        for (Album album : albums) {
            if (album.getName().equalsIgnoreCase(name)) {
                return album;
            }
        }
        System.out.println("Album: " + name + ", not found");
        return null;
    }
}
