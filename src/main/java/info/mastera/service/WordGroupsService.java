package info.mastera.service;

import info.mastera.model.WordGrouping;
import info.mastera.model.WordInfo;

import java.util.*;

public class WordGroupsService {

    private final Map<WordGrouping, List<Integer>> groups = new HashMap<>();

    public void add(WordInfo wordInfo) {
        if (groups.containsKey(wordInfo.getWordGrouping())) {
            groups.get(wordInfo.getWordGrouping()).add(wordInfo.getVowelsCount());
        } else {
            groups.put(wordInfo.getWordGrouping(), new ArrayList<>(List.of(wordInfo.getVowelsCount())));
        }
    }

    public Map<WordGrouping, List<Integer>> getGroups() {
        return groups;
    }
}
