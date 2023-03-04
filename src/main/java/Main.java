import java.io.IOException;

public class Main {

    final static String PATH_TO_LIBRARY = "src/main/resources/filmsData.json";

    public static void main(String[] args) throws IOException {
        Application app = new Application(PATH_TO_LIBRARY);
        app.start();
    }
}
