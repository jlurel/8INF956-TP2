package service;

import java.util.List;

public interface DictionaryService {
    boolean checkWord(String word);
    List<String> getWordStartingWith(String word);
}
