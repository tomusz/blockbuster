import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    Consumer<Stream> anyResult = stream -> {
        String consoleOutput = stream.count() > 0 ? "" : ConsoleMsg.getNoResultsForProvidedCriteria();
        System.out.println(consoleOutput);
    };
    private MovieLibrary movieLibrary;
    private String SAVE_FILE_PATH = "src/main/resources/newFilmsData.json";

    public Application(String pathToMovieLibrary) throws IOException {
        this.movieLibrary = MovieLibraryFileHandler.getMovieLibraryFromJSON(pathToMovieLibrary);
    }

    public String getSaveFilePath() {
        return SAVE_FILE_PATH;
    }

    public void setSaveFilePath(String SAVE_FILE_PATH) {
        this.SAVE_FILE_PATH = SAVE_FILE_PATH;
    }

    public void start() throws IOException {
        boolean exit = false;
        while (!exit) {
            System.out.println(ConsoleMsg.getApplicationMenu());
            switch (UserInputProvider.getInputFromScanner()) {
                case "1" -> findMoviesInDateRange(movieLibrary);
                case "2" -> System.out.println(getRandomMovie(movieLibrary));
                case "3" -> findMoviesWithActor(movieLibrary);
                case "4" -> {
                    exit = true;
                    MovieLibraryFileHandler.saveLibraryToJSON(SAVE_FILE_PATH, movieLibrary);
                }
                default -> System.out.println(ConsoleMsg.getMenuWrongOption());
            }

        }

    }

    private void findMoviesInDateRange(MovieLibrary movieLibrary) {
        System.out.println(ConsoleMsg.getProvideTwoDates());
        String[] dateRange = UserInputProvider.getInputFromScanner().split(" ");
        System.out.println(getMoviesInDates(movieLibrary, Integer.parseInt(dateRange[0])
                , Integer.parseInt(dateRange[1])));
    }

    private void findMoviesWithActor(MovieLibrary movieLibrary) {
        System.out.println(ConsoleMsg.getProvideFirstAndLastName());
        System.out.println(getMoviesByActor(movieLibrary,
                new Actor(UserInputProvider.getInputFromScanner())));
    }

    private List<Movie> getMoviesInDates(MovieLibrary movieLibrary, int startingDate, int endDate) {
        Stream<Movie> stream = movieLibrary.movies.stream()
                .filter(x -> x.getReleaseDate() >= startingDate)
                .filter(x -> x.getReleaseDate() <= endDate).toList().stream();
        anyResult.accept(stream);
        return stream.toList();
    }

    private List<Movie> getMoviesByActor(MovieLibrary movieLibrary, Actor actor) {
        return movieLibrary.movies.stream()
                .filter(movie -> movie.getCast().stream()
                        .anyMatch(mActor -> mActor.compareActors(actor)))
                .toList();
    }

    private Movie getRandomMovie(MovieLibrary movieLibrary) {
        return movieLibrary.movies.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), collected -> {
                    Collections.shuffle(collected);
                    return collected;
                })).get(0);
    }

}
