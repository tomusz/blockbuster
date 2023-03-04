import java.util.List;
import java.util.UUID;

public class Movie {

    private UUID id;
    private String title;
    private int releaseDate;
    private String genre;
    private Director director;
    private List<Actor> cast;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    @Override
    public String toString() {
        return "title : " + title + "\n" +
                "releaseDate : " + releaseDate + "\n" +
                "genre : " + genre + "\n" +
                "director : " + director + "\n" +
                "cast : " + cast + "\n";
    }
}
