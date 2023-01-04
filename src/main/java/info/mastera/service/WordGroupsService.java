package info.mastera.service;

import info.mastera.model.WordGrouping;
import info.mastera.model.WordInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class WordGroupsService {

    private final static WordGroupsService instance = new WordGroupsService();

    private final ConcurrentMap<WordGrouping, List<Integer>> groups = new ConcurrentHashMap<>();

    private WordGroupsService() {
    }

    public static WordGroupsService getInstance() {
        return instance;
    }

    public void add(WordInfo wordInfo) {
        if (groups.containsKey(wordInfo.getWordGrouping())) {
            groups.get(wordInfo.getWordGrouping()).add(wordInfo.getVowelsCount());
        } else {
            groups.put(wordInfo.getWordGrouping(), new ArrayList<>(List.of(wordInfo.getVowelsCount())));
        }
    }

    public ConcurrentMap<WordGrouping, List<Integer>> getGroups() {
        return groups;
    }
}
