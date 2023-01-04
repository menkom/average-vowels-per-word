package info.mastera.service;

import info.mastera.model.WordInfo;

public class WordProcessingThread implements Runnable {

    private final WordGroupsService wordGroupsService;
    private final String source;

    public WordProcessingThread(WordGroupsService wordGroupsService, String source) {
        this.wordGroupsService = wordGroupsService;
        this.source = source;
    }

    @Override
    public void run() {
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
