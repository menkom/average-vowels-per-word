package info.mastera.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WordGrouping {

    private final Set<Character> vowels = new HashSet<>();
    private int length = 0;

    public void increaseLength() {
        length++;
    }

    public void addVowel(char vowel) {
        vowels.add(Character.toLowerCase(vowel));
    }

    public Set<Character> getVowels() {
        return vowels;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "WordGrouping{" +
                "vowels=" + vowels +
                ", length=" + length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WordGrouping that = (WordGrouping) o;
        return length == that.length && vowels.equals(that.vowels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vowels, length);
    }
}
