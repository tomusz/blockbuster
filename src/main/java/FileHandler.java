import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {

    private static Gson gson = new Gson();

    public static <T> T getClassFromJSON(String path, Class<T> targetType) throws IOException {
        Class object;
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(path));
            object = gson.fromJson(reader, targetType.getClass());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            reader.close();
        }
        return (T) object;
    }

    public static <T> void saveClassToJSON(String path, Class<T> targetClass) throws IOException {
        Writer writer = null;
        try {
            writer = Files.newBufferedWriter(Paths.get(path));
            gson.toJson(targetClass, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            writer.close();
        }

    }
}
