package info.mastera.model;

public class WordInfo {

    private static final String VOWELS = "aeiouAEIOU";

    private final WordGrouping wordGrouping = new WordGrouping();
    private int vowelsCount = 0;

    public void add(char letter) {
        wordGrouping.increaseLength();
        if (VOWELS.indexOf(letter) != -1) {
            wordGrouping.addVowel(letter);
            vowelsCount++;
        }
    }

    public WordGrouping getWordGrouping() {
        return wordGrouping;
    }

    public int getVowelsCount() {
        return vowelsCount;
    }

    @Override
    public String toString() {
        return "WordInfo{" +
                "wordGrouping=" + wordGrouping +
                ", vowelsCount=" + vowelsCount +
                '}';
    }
}
