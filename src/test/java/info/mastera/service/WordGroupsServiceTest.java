package info.mastera.service;

import info.mastera.model.WordInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class WordGroupsServiceTest {

    private WordGroupsService wordGroupsService;

    @Test
    public void addFirstInfoTest() {
        wordGroupsService = new WordGroupsService();
        Assertions.assertNotNull(wordGroupsService.getGroups());
        Assertions.assertTrue(wordGroupsService.getGroups().isEmpty());

        WordInfo wordInfo = new WordInfo();
        wordGroupsService.add(wordInfo);

        Assertions.assertNotNull(wordGroupsService.getGroups());
        Assertions.assertEquals(1, wordGroupsService.getGroups().size());
        Assertions.assertTrue(wordGroupsService.getGroups().containsKey(wordInfo.getWordGrouping()));
        Assertions.assertIterableEquals(List.of(0), wordGroupsService.getGroups().get(wordInfo.getWordGrouping()));
    }

    @Test
    public void addFirstAnotherKeyValueTest() {
        wordGroupsService = new WordGroupsService();
        WordInfo wordInfo = new WordInfo();
        wordGroupsService.add(wordInfo);

        wordInfo.add('a');
        wordGroupsService.add(wordInfo);

        Assertions.assertNotNull(wordGroupsService.getGroups());
        Assertions.assertEquals(2, wordGroupsService.getGroups().size());
        Assertions.assertTrue(wordGroupsService.getGroups().containsKey(wordInfo.getWordGrouping()));
        Assertions.assertIterableEquals(List.of(1), wordGroupsService.getGroups().get(wordInfo.getWordGrouping()));
    }

    @Test
    public void addNextValueForKeyTest() {
        wordGroupsService = new WordGroupsService();
        WordInfo wordInfo = new WordInfo();
        wordGroupsService.add(wordInfo);

        wordGroupsService.add(wordInfo);

        Assertions.assertNotNull(wordGroupsService.getGroups());
        Assertions.assertEquals(1, wordGroupsService.getGroups().size());
        Assertions.assertTrue(wordGroupsService.getGroups().containsKey(wordInfo.getWordGrouping()));
        Assertions.assertIterableEquals(List.of(0, 0), wordGroupsService.getGroups().get(wordInfo.getWordGrouping()));
    }
}