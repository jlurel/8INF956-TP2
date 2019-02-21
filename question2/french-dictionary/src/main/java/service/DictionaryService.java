package service;

import java.util.List;

public interface DictionaryService {
    public boolean checkWord(String word);
    public List<String> getWordStartingWith(String word);
}
