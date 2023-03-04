import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MovieLibraryFileHandler {

    private static Gson gson = new Gson();

    public static MovieLibrary getMovieLibraryFromJSON(String path) throws IOException {
        MovieLibrary movieLibrary;
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(path));
            movieLibrary = gson.fromJson(reader, MovieLibrary.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            reader.close();
        }
        return movieLibrary;
    }

    public static void saveLibraryToJSON(String path, MovieLibrary movieLibrary) throws IOException {
        Writer writer = null;
        try {
            writer = Files.newBufferedWriter(Paths.get(path));
            gson.toJson(movieLibrary, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            writer.close();
        }

    }
}
