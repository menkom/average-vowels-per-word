package info.mastera.service;

import info.mastera.model.WordInfo;

public class WordService {

    private final WordGroupsService wordGroupsService;

    public WordService(WordGroupsService wordGroupsService) {
        this.wordGroupsService = wordGroupsService;
    }

    public void process(String source) {
        WordInfo wordInfo = null;
        for (int i = 0; i < source.length(); i++) {
            char currentChar = source.charAt(i);
            if (Character.isLetter(currentChar)) {
                if (wordInfo == null) {
                    wordInfo = new WordInfo();
                }
                wordInfo.add(currentChar);
            } else {
                if (wordInfo != null) {
                    wordGroupsService.add(wordInfo);
                    wordInfo = null;
                }
            }
        }
    }
}
