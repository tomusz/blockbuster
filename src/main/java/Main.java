import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        //TODO: serialization and deserialization
        // TODO: get data from JSON store data to JSON
        //TODO: menu
//        1. Podaj dwie daty aby wyświetlić nazwy filmów wydanych pomiędzy tymi datami
//        2. Wyświetl wszystkie informacje o losowym filmie
//        3. Podaj imię i nazwisko aktora aby wyświetlić nazwy filmów w jakich zagrał

        //TODO: Komentarz do opcji 2:
//        Wyświetlenie wszystkich informacji o filmie rozumiem jako wypisanie ich np. w takim formacie:
//        title: The Shawshank Redemption
//        director: Frank Darabont
//        genre: drama
//        date: 1994
//        actors: Tim Robbins, Morgan Freeman, Bob Gunton
//
//        Powyższy efekt powinien być uzyskany poprzez nadpisania metody toString() w klasach typu Movie, Actor itd..
        File fileActor = new File("src/main/resources/oneActor.json");
        File fileMovie = new File("src/main/resources/moviesWithOneDirector.json");

        // create a reader
        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/oneActor.json"));
        Reader movieReader = Files.newBufferedReader(Paths.get("src/main/resources/moviesWithOneDirector.json"));
        Reader allMoviesReader = Files.newBufferedReader(Paths.get("src/main/resources/filmsData.json"));


        MovieLibrary classFromJSON = MovieLibraryFileHandler.getMovieLibraryFromJSON("src/main/resources/filmsData.json");
        System.out.println(classFromJSON);
        MovieLibraryFileHandler.saveLibraryToJSON("src/main/resources/newFilmsData.json",classFromJSON);

    }
}
