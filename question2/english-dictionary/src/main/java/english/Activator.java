package english;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import service.DictionaryService;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Activator implements BundleActivator {
    public void start(BundleContext context) throws Exception {
        Hashtable<String, String> properties = new Hashtable<String, String>();
        properties.put("Language", "English");
        context.registerService(DictionaryService.class.getName(), new DictionaryImpl(), properties);
    }

    public void stop(BundleContext context) throws Exception {

    }

    private static class DictionaryImpl implements DictionaryService {
        List<String> dictionary;
        {
            try {
                InputStream inputStream = getClass().getResourceAsStream("/english.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line;
                dictionary = new ArrayList<String>();
                while ((line = bufferedReader.readLine()) != null)
                {
                    String [] words = line.split("\\s+");
                    dictionary.addAll(Arrays.asList(words));
                }
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public boolean checkWord(String word) {
            word = word.toLowerCase();

            for (String s : dictionary) {
                if (word.equals(s)) {
                    return true;
                }
            }
            return false;
        }

        public List<String> getWordStartingWith(String word) {
            word = word.toLowerCase();
            List<String> words = new ArrayList<String>();

            for (String s : dictionary) {
                if (s.startsWith(word)) {
                    words.add(s);
                }
            }
            return words;
        }
    }
}
