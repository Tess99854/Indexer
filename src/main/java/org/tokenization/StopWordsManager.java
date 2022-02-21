package org.tokenization;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StopWordsManager {

    private final List<String> availableLanguages = Arrays.asList("en", "fr");
    private HashSet<String> stopwords = new HashSet<>();
    private String language;

    public StopWordsManager() {
        this.language = availableLanguages.get(0);
    }

    public StopWordsManager(String language) {
        if (this.availableLanguages.contains(language)) {
            this.language = language;
        } else {
            this.language = availableLanguages.get(0);
        }
    }

    public ArrayList<String> getStopWords() throws FileNotFoundException {
        String path = "src/ressources/StopLists/stopwords." + this.language;
        File file = new File(path);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            stopwords.add(sc.nextLine());
        }
        return new ArrayList<>(this.stopwords);
    }

    public void extendList(List<String> extendWords) throws FileNotFoundException {
        getStopWords();
        stopwords.addAll(extendWords);
    }

}
