import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 * */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {
//        return checkWordTrie(text, dictionary);
        return checkWordTST(text, dictionary);
    }

    public String[] checkWordTST(String[] text, String[] dictionary) {
        ArrayList<String> misspelledArray = new ArrayList<>();
        TST dict = new TST();
        TST misspelled = new TST();

        for (String s : dictionary) {
            dict.addWord(s);
        }

        for (String s : text) {
            if (!dict.checkWord(s) && !misspelled.checkWord(s)) {
                misspelled.addWord(s);
                misspelledArray.add(s);
            }
        }
        return misspelledArray.toArray(new String[0]);
    }

    public String[] checkWordTrie(String[] text, String[] dictionary) {
        ArrayList<String> misspelledArray = new ArrayList<>();
        Trie dict = new Trie();
        Trie misspelled = new Trie();

        for (String s : dictionary) {
            dict.addWord(s);
        }

        for (String s : text) {
            if (!dict.isWord(s) && !misspelled.isWord(s)) {
                misspelled.addWord(s);
                misspelledArray.add(s);
            }
        }

        return misspelledArray.toArray(new String[0]);
    }



}
