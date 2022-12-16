package info.mastera.service;

import info.mastera.model.WordGrouping;

import java.util.*;
import java.util.stream.Collectors;

public class OutputTransformService {

    public List<String> transformToAverageVowels(Map<WordGrouping, List<Integer>> groups) {
        List<String> averageVowels = new ArrayList<>();
        for (Map.Entry<WordGrouping, List<Integer>> entry : groups.entrySet()) {
            averageVowels.add(transform(entry));
        }
        return averageVowels;
    }

    public String transform(Map.Entry<WordGrouping, List<Integer>> entry) {
        return "(%s, %s) -> %s"
                .formatted(
                        transform(entry.getKey().getVowels()),
                        entry.getKey().getLength(),
                        transform(entry.getValue())
                );
    }

    public double transform(List<Integer> vowelsPerWord) {
        return vowelsPerWord.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }

    public String transform(Set<Character> vowels) {
        return vowels.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(",", "{", "}"));
    }
}
