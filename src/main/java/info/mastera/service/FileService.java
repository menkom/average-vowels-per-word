package info.mastera.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileService {

    private final WordService wordService;

    public FileService(WordService wordService) {
        this.wordService = wordService;
    }

    public void load(String filename) {
        Path filePath = Paths.get("./" + filename);
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                //this can be done in separate thread if project need this acceleration
                wordService.process(line);
            }
        } catch (NoSuchFileException e) {
            System.out.printf("No file %s found.%n", filename);
        } catch (IOException e) {
            System.out.println("File reading error.");
        }
    }

    public void save(List<String> lines) {
        Path filePath = Paths.get("./OUTPUT.TXT");
        try {
            Files.write(filePath, lines);
        } catch (IOException e) {
            System.out.println("Error saving info to file.");
        }
    }
}
