import java.util.ArrayList;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Liam Krenz
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

    // Uses a TST to find misspelled words
    public String[] checkWordTST(String[] text, String[] dictionary) {
        ArrayList<String> misspelledArray = new ArrayList<>();
        TST dict = new TST(dictionary[0].charAt(0));
        TST misspelled = new TST('m');

        // Adds words to the dictionary
        for (String s : dictionary) {
            dict.addWord(s);
        }

        // If words aren't present in the dictionary or misspelled word TST, they are added to misspelled
        for (String s : text) {
            if (dict.checkWord(s) && misspelled.checkWord(s)) {
                misspelled.addWord(s);
                misspelledArray.add(s);
            }
        }
        return misspelledArray.toArray(new String[0]);
    }

    // Uses a Trie to find misspelled words
    public String[] checkWordTrie(String[] text, String[] dictionary) {
        ArrayList<String> misspelledArray = new ArrayList<>();
        Trie dict = new Trie();
        Trie misspelled = new Trie();

        // Creates the dictionary
        for (String s : dictionary) {
            dict.addWord(s);
        }

        // If words aren't present in the dictionary or misspelled word Trie, they are added to misspelled
        for (String s : text) {
            if (dict.checkWord(s) && misspelled.checkWord(s)) {
                misspelled.addWord(s);
                misspelledArray.add(s);
            }
        }

        return misspelledArray.toArray(new String[0]);
    }



}
