package info.mastera.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileService {

    public void load(String filename) {
        Path filePath = Paths.get("./" + filename);
        ExecutorService executorService = Executors.newWorkStealingPool();
        var futures = new LinkedList<Future<?>>();
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                WordProcessingThread thread = new WordProcessingThread(WordGroupsService.getInstance(), line);
                futures.add(executorService.submit(thread));
            }
            executorService.shutdown();
            for (Future<?> future : futures) {
                future.get();
            }
        } catch (NoSuchFileException e) {
            System.out.printf("No file %s found.%n", filename);
        } catch (IOException e) {
            System.out.println("File reading error.");
        } catch (ExecutionException e) {
            System.out.println("Execution exception.");
        } catch (InterruptedException e) {
            System.out.println("Process interrupted.");
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
