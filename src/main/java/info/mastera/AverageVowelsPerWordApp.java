package info.mastera;

import info.mastera.service.FileService;
import info.mastera.service.OutputTransformService;
import info.mastera.service.WordGroupsService;

import java.util.List;

public class AverageVowelsPerWordApp {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        WordGroupsService wordGroupsService = WordGroupsService.getInstance();
        FileService fileService = new FileService();
        fileService.load(args.length == 0 ? "INPUT.TXT" : args[0]);
        List<String> averageVowels = new OutputTransformService().transformToAverageVowels(wordGroupsService.getGroups());
        fileService.save(averageVowels);
        System.out.println("Program finished in " + (System.currentTimeMillis() - time));
    }
}