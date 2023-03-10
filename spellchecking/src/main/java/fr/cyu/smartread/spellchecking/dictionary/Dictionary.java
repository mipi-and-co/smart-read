package fr.cyu.smartread.spellchecking.dictionary;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class Dictionary {
    private ArrayList<String> wordList;

    public Dictionary() {
        wordList = new ArrayList<>(0);
    }

    public ArrayList<String> getWordList() {
        return wordList;
    }

    public Dictionary addWord(String word) {
        wordList.add(word);
        return this;
    }

    public Dictionary populateFromFile(String path) throws IOException {
        File file = new File(path);
        String line;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        while ((line = br.readLine()) != null) {
            addWord(line);
        }
        br.close();
        fr.close();
        return this;
    }
}
