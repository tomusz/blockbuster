import java.util.List;
import java.util.UUID;

public class Movie {

//    Każdy film powinien mieć: tytuł, rok wydania, reżysera, gatunek oraz listę aktorów (ofc ta też nie statyczna)

    private UUID id;
    private String title;
    private int releaseDate;
    private String genre;

    private Director director;

    private List<Actor> cast;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", genre='" + genre + '\'' +
                ", director=" + director +
                ", cast=" + cast +
                '}';
    }
}
