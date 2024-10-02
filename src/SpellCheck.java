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
        ArrayList<String> misspelled = new ArrayList<>();
        Storage map = new Storage();

        // Adds all words to the storage tree
        // While I could be loosing some efficiency here, the same dictionary is loaded in for all cases and this step
        // doesn't seem to be taking too much time.
        for (String s : dictionary) {
            map.setChild(s);
        }

        // Iterates through words and checks if they are in the storage tree
        // This is the main section that I can improve on. While the code runs in the same categorical runtime
        // as the solution, there are probably some ways I can speed up this section.
        for (String s : text) {

            // Ensures word has not already been labeled as misspelled
            // I might be able to increase the efficiency of the .contains() method through coding my own implementation
            if (!map.checkWord(s) && !misspelled.contains(s)) {
                misspelled.add(s);
            }
        }

        // Returns the misspelled words
        return misspelled.toArray(new String[0]);

        // Adds every word in the dictionary to the hash table
        LinkedHashSet<String> words = new LinkedHashSet<>(Arrays.asList(dictionary));
        ArrayList<String> misspelled = new ArrayList<>();

        // Iterates through every word in the text and checks if it is in the has table
        for (String word : text) {
            if (!words.contains(word) && !misspelled.contains(word))
                misspelled.add(word);
        }
        return misspelled.toArray(new String[0]);

    }



}
