package info.mastera;

import info.mastera.service.FileService;
import info.mastera.service.OutputTransformService;
import info.mastera.service.WordGroupsService;
import info.mastera.service.WordService;

import java.util.List;

public class AverageVowelsPerWordApp {

    public static void main(String[] args) {
        WordGroupsService wordGroupsService = new WordGroupsService();
        WordService wordService = new WordService(wordGroupsService);
        FileService fileService = new FileService(wordService);
        fileService.load(args.length == 0 ? "INPUT.TXT" : args[0]);
        List<String> averageVowels = new OutputTransformService().transformToAverageVowels(wordGroupsService.getGroups());
        fileService.save(averageVowels);
    }
}