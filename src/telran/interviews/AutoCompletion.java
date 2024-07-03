package telran.interviews;

import java.util.HashSet;
import java.util.TreeSet;

public class AutoCompletion {
    TreeSet<String> words = new TreeSet<>(String::compareToIgnoreCase);
    public boolean addWord(String word){
        return words.add(word);
    }

    public String[] getVariants(String prefix) {
        String rangeString = prefix.substring(0, prefix.length()-1) + (char)(prefix.charAt(prefix.length()-1) + 1);
        return words.
                subSet(prefix, rangeString)
                .toArray(String[]::new);
    }
}
