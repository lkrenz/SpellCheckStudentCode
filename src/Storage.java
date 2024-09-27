public class Storage {
    Storage[] children;
    boolean isWord;

    public Storage(boolean isWord) {
        this.isWord = isWord;
        this.children = new Storage[27];
    }

    public Storage() {
        this.isWord = false;
        this.children = new Storage[27];
    }

    // These methods work, but there is probably a way I can remove redundant steps
    public void setChild(String value) {

        // Completes word and returns
        if (value.isEmpty()) {
            isWord = true;
            return;
        }

        // Sends value to correct child
        int val = (int) value.charAt(0) - 97;
        if (val < 0) {
            val = 26;
        }

        // Creates new child is one doesn't exist
        if (children[val] == null) {
            children[val] = new Storage();
        }

        // Handles sending empty string to correct child
        String newValue;
        if (value.length() == 1) {
            newValue = "";
        }
        else {
            newValue = value.substring(1);
        }

        // Moves on to child
        children[val].setChild(newValue);
    }

    public boolean checkWord(String value) {

        // Base case for if the word is in the dictionary
        if (this.isWord && value.isEmpty()) {
            return true;
        }
        else if (value.isEmpty()) { // There might be a way to avoid this being a second check
            return false;
        }

        // This section works around substring() not working on string of length 1
        String word;
        if (value.length() == 1) {
            word = "";
        }
        else { // Cuts off the first character
            word = value.substring(1);
        }

        // Converts value to a-z range
        int val = (int) value.charAt(0) - 97;

        // Handles apostrophe
        if (val < 0) {
            val = 26;
        }

        // Handles non english letters
        if (val > 26) {
            return false;
        }

        // If there is no child, the word is not in the library
        if (children[val] == null) {
            return false;
        }

        // Moves on the correct child
        return children[val].checkWord(word);
    }
}